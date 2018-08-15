package designPattern.strategy;

public enum StrategyInfo {
	RpcStrategy("designPattern.strategy.RpcStrategy"),
	HttpStrategy("designPattern.strategy.HttpStrategy");
	
	private String className;
	

    StrategyInfo(String className) {
        this.setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
