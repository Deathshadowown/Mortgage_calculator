/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   MortgageCalculator.java                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/25 16:46:09 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/25 16:46:09 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package src;

import java.util.*;
import java.text.NumberFormat;

public class MortgageCalculator{
    public static void main(String[] args){
        try{
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        final byte MOTHS_IN_YEAR = 100;
        final byte PERSENT = 12;
        Scanner scanner = new Scanner(System.in);
        long principal;
        double annualInterestRate;
        int periodYears;
        while (true)
        {
            System.out.print("Principal: "); // amount of loan you want to get
            principal = scanner.nextLong();
            if (principal < 1_000)
            {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }
            break;
        }
        while (true)
        {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate <= 0 || annualInterestRate > 30)
            {
                System.out.println("Enter a value greater than 0 or less than 30");
                continue;
            }
            break;
        }
        while(true)
        {
            System.out.print("Period (Years): "); // loan to pay back in X amount of years
            periodYears = scanner.nextByte();
            if (periodYears <= 0 || periodYears > 30)
            {
                System.out.println("Enter a value between 1 and 30");
                continue;
            }
            break ;
        }
            double monthlyIntrests = annualInterestRate / PERSENT / MOTHS_IN_YEAR;
            int amoutOfPayments = periodYears / MOTHS_IN_YEAR;
            // double mortgage = principal * ((annualInterestRate /= 100) / 12) * (Math.pow(1 + annualInterestRate, periodYears) / (Math.pow(annualInterestRate + 1, periodYears) - 1));
            double mortgage = principal * (monthlyIntrests * Math.pow(1 + monthlyIntrests, amoutOfPayments)) / (Math.pow(1 + monthlyIntrests, amoutOfPayments));
            System.out.println("Mortgage: "+ formatter.format(mortgage));
    } catch (java.util.InputMismatchException e){
        System.out.println("User must enter a number");
    } catch (Exception e)
    {
        System.out.println("Something is wrong");
    }
    }
}