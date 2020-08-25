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
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        final byte MOTHS_IN_YEAR = 100;
        final byte PERSENT = 12;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: "); // amount of loan you want to get
        long principal = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        double monthlyIntrests = annualInterestRate / PERSENT / MOTHS_IN_YEAR;
        System.out.print("Period (Years): "); // loan to pay back in X amount of years
        int periodYears = scanner.nextByte();
        int amoutOfPayments = periodYears / MOTHS_IN_YEAR;
        // double mortgage = principal * ((annualInterestRate /= 100) / 12) * (Math.pow(1 + annualInterestRate, periodYears) / (Math.pow(annualInterestRate + 1, periodYears) - 1));
        double mortgage = principal * (monthlyIntrests * Math.pow(1 + monthlyIntrests, amoutOfPayments)) / (Math.pow(1 + monthlyIntrests, amoutOfPayments));
        System.out.println("Mortgage: "+ formatter.format(mortgage));
    }
}