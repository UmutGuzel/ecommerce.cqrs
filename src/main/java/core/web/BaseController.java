package core.web;

import an.awesome.pipelinr.Pipeline;


public class BaseController {

    //protexted olması çünkü knedisini extend eden classlardan erişebilsin diye

    protected final Pipeline pipeline;

    public BaseController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }
}

