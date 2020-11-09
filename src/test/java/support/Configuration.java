package support;

import java.util.List;
import java.util.Map;

public class Configuration {
    public String browser;
    public String testEnvironment;
    public boolean isHeadless;
    public int implicitTimeOut;
    public int pageLoadTimeOut;
    public int explicitTimeOut;
    public List<String> supportedOsList;
    public Map <String, String> admin;
    public Map <String, String> user;
}
