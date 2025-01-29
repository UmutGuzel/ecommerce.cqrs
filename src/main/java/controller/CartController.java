package controller;


import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs3.application.cart.command.create.CreateCartCommand;
import com.turkcell.turkcellcqrs3.application.cart.command.create.CreatedCartResponse;
import com.turkcell.turkcellcqrs3.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController extends BaseController {

    public CartController(Pipeline pipeline) {
        super(pipeline);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedCartResponse create(@RequestBody CreateCartCommand createCartCommand) {
        return createCartCommand.execute(pipeline);
    }


}
