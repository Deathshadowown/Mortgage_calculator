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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: "); // amount of loan you want to get
        long principal = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Period (Years): "); // loan to pay back in X amount of years
        int periodYears = scanner.nextByte();
        double mortgage = principal * ((annualInterestRate /= 100) / 12) * (Math.pow(1 + annualInterestRate, periodYears) / (Math.pow(annualInterestRate + 1, periodYears) - 1));
        System.out.println("Mortgage: "+ formatter.format(mortgage));
    }
}