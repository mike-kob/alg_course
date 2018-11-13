package pack;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		StudentsGradesGeneric<Double> sgg = new StudentsGradesGeneric<>(Double.class);
		Scanner scan = new Scanner(System.in);
		
		sgg.setGrades(new Double[] { 94.2, 58.15, 75.99 });

		System.out.println("Add marks of students (when you're finished, enter \"-1\"): ");
		double mark = scan.nextDouble();
		while (mark != -1) {
			if (mark < -1) {
				System.out.println("Cannot allow a negative mark.");
			} else {
				sgg.addGrade(mark);
			}
			mark = scan.nextDouble();
		}

		System.out.println("Max mark: " + sgg.getMaxMark());
		System.out.println("Min mark: " + sgg.getMinMark());
		System.out.println("Average maark: " + sgg.getAverageMark());
		System.out.println("Students with the mark higher than average: " + sgg.getStudsAboveAver());
		System.out.println("Students with the mark lower than average: " + sgg.getStudsBelowAver());
		System.out.println("Students with 'Excellent': " + sgg.getStudsWithExcellent());
		System.out.println("Students with 'Good': " + sgg.getStudsWithGood());
		System.out.println("Students with 'Satisfactory': " + sgg.getStudsWithSatisf());
		System.out.println(sgg.toString());
		scan.close();
	}
}
