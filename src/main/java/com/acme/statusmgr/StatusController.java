package com.acme.statusmgr;

import com.acme.statusmgr.beans.*;
import com.acme.statusmgr.beans.Facades.DetailsFacade;
import com.acme.statusmgr.beans.Facades.DetailsFacadeInterface;
import com.acme.statusmgr.beans.Facades.MockDetailsFacade;
import com.acme.statusmgr.beans.decorators.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * <a href="http://localhost:8080/server/status">Default Page</a>
 * <p>
 * <a href="http://localhost:8080/server/status?name=Noach">Default with name</a>
 * <p>
 * You can include an optional 'details' parameter with a list of server status details being requested.
 * <p>
 * Examples:
 * <a href="http://localhost:8080/server/status/detailed?details=availableProcessors">Detailed Processors</a>
 * <p>
 * <a href="http://localhost:8080/server/status/detailed?name=Noach&details=availableProcessors,freeJVMMemory">Name and Full Details</a>
 * </p>
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();
    static boolean isTest = false;

    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requester
     * @return a ServerStatus object containing the info to be returned to the requestor
     * @apiNote TODO since Spring picks apart the object returned with Reflection and doesn't care what the return-object's type is, we can change the type of object we return if necessary, as long as the object returned contained the required fields and getter methods.
     */
    @RequestMapping("/status")
    public ServerStatus getStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        return new ServerStatus(counter.incrementAndGet(), String.format(template, name));
    }


    /**
     * Process a request for detailed server status information
     *
     * @param name    optional param identifying the requester
     * @param details optional param with a list of server status details being requested
     * @return a ServerStatus object containing the info to be returned to the requestor
     * @apiNote TODO since Spring picks apart the object returned with Reflection and doesn't care what the return-object's type is, we can change the type of object we return if necessary
     */
    @RequestMapping("/status/detailed")
    public ServerInterface getDetailedStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                             @RequestParam(name = "details", required = false) List<String> details) {
        DetailsFacadeInterface myFacade = isTest ? new MockDetailsFacade() : new DetailsFacade();

        ServerInterface detailedStatus = new ServerStatus(counter.incrementAndGet(), String.format(template, name), myFacade);

        if (details != null) {
            Logger logger = LoggerFactory.getLogger("StatusController");
            logger.info("Details were provided: {}", Arrays.toString(details.toArray()));

            for (String detail : details) {
                logger.info("Processing detail: {}", detail);
                detailedStatus = decoratorPicker(detailedStatus, detail);
            }

        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Required request parameter 'details' for method parameter type List is not present");

        return detailedStatus;
    }

    ServerInterface decoratorPicker(ServerInterface serverInterface, String detail) {
        Logger logger = LoggerFactory.getLogger("DecoratorPicker");

        return switch (detail) {
            case "availableProcessors" -> {
                logger.info("Picking AvailableProcessorsDecorator");
                yield new AvailableProcessorsDecorator(serverInterface);
            }
            case "freeJVMMemory" -> {
                logger.info("Picking FreeJVMMemoryDecorator");
                yield new FreeJVMMemoryDecorator(serverInterface);
            }
            case "totalJVMMemory" -> {
                logger.info("Picking TotalJVMMemoryDecorator");
                yield new TotalJVMMemoryDecorator(serverInterface);
            }
            case "jreVersion" -> {
                logger.info("Picking JreVersionDecorator");
                yield new JreVersionDecorator(serverInterface);
            }
            case "tempLocation" -> {
                logger.info("Picking TempLocationDecorator");
                yield new TempLocationDecorator(serverInterface);
            }
            default -> {
                logger.error("Invalid details option: {}", detail);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid details option: " + detail);
            }
        };
    }

    public static void setSystemInfoFacade(boolean test) {
        isTest = test;
    }
}
