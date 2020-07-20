//ler o numeros de pessoas ou empresas a calcular uma taxa anual, conforme o rendimento e seus gastos em saude

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double annualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
			}
			
			else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, annualIncome, numberOfEmployees));
			}
			
		}
		
		double totalTaxes = 0;
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for (Person person : list) {
			System.out.println(person.getName() + ": $" + String.format("%.2f", person.tax()));
			totalTaxes += person.tax();
		}
		
		System.out.println();
		System.out.println(String.format("TOTAL TAXES: $ " + "%.2f", totalTaxes));
		
		sc.close();
	}

}
