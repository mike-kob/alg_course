package pack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StudentsGradesGeneric<N extends Number & Comparable<N>> {

	private N[] grades;
	private N maxMark, minMark;
	private int studsBelowAver, studsAboveAver, studsWithExcellent, studsWithGood, studsWithSatisf;
	private double averMark;


	@SuppressWarnings("unchecked")
	public StudentsGradesGeneric(Class<N> cls) {
		grades = (N[])Array.newInstance(cls, 0);		
	}
	
	@SuppressWarnings("unchecked")
	public StudentsGradesGeneric(Class<N> cls, int size) {
		grades = (N[])Array.newInstance(cls, size);
				
	}
	
	
	public int getStudsBelowAver() {
		return studsBelowAver;
	}

	public int getStudsAboveAver() {
		return studsAboveAver;
	}

	public int getStudsWithExcellent() {
		return studsWithExcellent;
	}

	public int getStudsWithGood() {
		return studsWithGood;
	}

	public int getStudsWithSatisf() {
		return studsWithSatisf;
	}

	

	public N[] getGrades() {
		return grades;
	}

	public N getMaxMark() {
		return maxMark;
	}

	public N getMinMark() {
		return minMark;
	}

	public double getAverageMark() {
		return averMark;
	}

	public void setGrades(N[] grades) {
		this.grades = grades;
		update();
	}

	public void addGrade(N mark) {
		grades = Arrays.copyOf(grades, grades.length + 1);
		grades[grades.length - 1] = mark;

		update();
		
	}

	public String toString() {
		String str = "";
		for (N i : grades)
			str += i + "; ";
		return str;
	}
	
	private void update() {
		studsBelowAver = 0;
		studsAboveAver = 0;
		studsWithExcellent = 0;
		studsWithGood = 0;
		studsWithSatisf = 0;
		maxMark = grades[0];
		minMark = grades[0];
		
		double sum = 0;
		for (N i : grades) {
			if (i.compareTo(maxMark) == 1)
				maxMark = i;
			if (i.compareTo(minMark) == -1)
				minMark = i;
			sum += i.doubleValue();
		}

		averMark = sum / grades.length;

		for (N i : grades) {
			double grade = i.doubleValue();

			if (grade < averMark)
				studsBelowAver++;
			else
				studsAboveAver++;
			if (grade > 90) {
				studsWithExcellent++;
			} else if (grade > 70) {
				studsWithGood++;
			} else if (grade >= 60) {
				studsWithSatisf++;
			}
		}
	}
}
