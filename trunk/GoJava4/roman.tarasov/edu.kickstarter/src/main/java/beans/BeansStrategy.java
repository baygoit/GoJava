package beans;

import java.util.HashMap;

public class BeansStrategy {
	private volatile static BeansStrategy uniqueInstance;
	private static HashMap<eBeans, iBean> beans;

	private BeansStrategy() {
	}

	public static BeansStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (BeansStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new BeansStrategy();
					beans = new HashMap<eBeans, iBean>();

					beans.put(eBeans.MAIN_M, new Main());
					beans.put(eBeans.PROJECT_M, new DetailedProject());
					beans.put(eBeans.PROJECTS_M, new Projects());
					beans.put(eBeans.LOGIN_M, new Login());
					beans.put(eBeans.DONATE_M, new Donate());
					beans.put(eBeans.INVEST_M, new Invest());
					beans.put(eBeans.COMMENT_M, new Comment());
					beans.put(eBeans.COMMENT_FORM_M, new CommentForm());
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized iBean getComponent(eBeans selectedBean) {
		return beans.get(selectedBean);
	}
}
