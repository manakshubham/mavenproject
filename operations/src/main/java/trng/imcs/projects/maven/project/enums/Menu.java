package trng.imcs.projects.maven.project.enums;

public enum Menu {
	CREATEEMPLOYEE(1), VIEWEMPLOYEE(2), VIEWALLEMPLOYEES(3), UPDATEEMPLOYEE(4), DELETEEMPLOYEE(5), CALCULATEHRA(
			6), CALCUALTEGROSSSALARY(7), EXIT(8);

	int value;

	Menu(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Menu getMenuByValue(int value) {
		for (Menu menu : Menu.values()) {
			if (menu.getValue() == value) {
				return menu;
			}
		}
		return null;
	}
}
