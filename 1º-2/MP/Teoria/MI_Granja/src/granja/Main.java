package granja;

public class Main {

	public static void main(String[] args) {
		Fertilizante fertilizante = new Fertilizante(12, 7, 10);
		Planta[] vP = { new Raiz("Carrot", "June", fertilizante, 0.2),
				new Hoja("Letucce", "May", fertilizante, 0.4, 50),
				new Fruto("Tomato", "June", fertilizante, 0.5, true, "Sulphur"),
				new Hueso("Peach", "August", fertilizante, 9, 2, "Cooper"),
				new Pepita("Apple", "July", fertilizante, 10) };

		for (Planta p : vP)
			System.out.println(p);

		showHighestWateConsumption(vP);
		showPlantsFungi(vP);
		System.out.format("Number of plants without fertilizer: %d\n", countPlantsWithoutFertilizer(vP));
		sortPlants(vP);
		System.out.println("Plants afer sorting:");
		for (Planta p : vP)
			System.out.println(p);
	}

	private static void showHighestWateConsumption(Planta[] vP) {
		Planta max = null;
		for (Planta p : vP)
			if (max == null || max.getLitros() < p.getLitros())
				max = p;

		if (max == null)
			System.out.println("No plant found");
		else
			System.out.format("Plant with highest water consumption and care:\n\t%s\t%s\n", max, max.cuidar());
	}

	private static void showPlantsFungi(Planta[] vP) {
		System.out.println("Plants that are targeted by Fungi:");
		for (Planta p : vP)
			if (p instanceof Hongos)
				System.out.format("\t%s with fungicide %s\n", p.getNombre(), ((Hongos) p).fungicida());
	}

	private static int countPlantsWithoutFertilizer(Planta[] vP) {
		int count = 0;
		for (Planta p : vP)
			if (p.getFertilizante() == null)
				count++;
		return count;
	}

	private static void sortPlants(Planta[] vP) {
		int left = 0, right = vP.length - 1;
		while (left < right) {
			if (vP[left] instanceof Hortalizas) {
				if (vP[right] instanceof ArbolFrutal) {
					// swapping
					Planta temp = vP[left];
					vP[left] = vP[right];
					vP[right] = temp;
				} else
					right--;
			} else
				left++;
		}

	}

}
