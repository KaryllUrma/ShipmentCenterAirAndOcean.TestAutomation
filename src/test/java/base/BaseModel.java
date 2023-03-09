package base;

import Resources.RestAPIHelper;

public class BaseModel {
    protected RestAPIHelper _restAPIHelper;

    public BaseModel() {
        _restAPIHelper = new RestAPIHelper();
    }
}
