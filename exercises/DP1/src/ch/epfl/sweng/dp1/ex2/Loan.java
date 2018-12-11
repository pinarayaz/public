package ch.epfl.sweng.dp1.ex2;

/* Example from Refactoring to Patterns */

import java.util.Date;

/**
 * This class represents a Loan in a bank. There are different types of Loans: term loan, revolver loan and RCTL loan.
 * Several constructors are provided to create different loans of different types.
 */
public class Loan{

    CapitalStrategy capitalStrategy;
    double commitment;
    double outstanding;
    Date maturity;
    Date expiry;
    int riskTaking;

    public static Loan newTermLoan(double commitment, int riskTaking, Date maturity){
        CapitalStrategy capitalStrategy = new CapitalStrategyTermLoan();
        return new Loan(capitalStrategy, commitment, 0.0, riskTaking, maturity, null);
    }

    public static Loan newRevolverLoan(double commitment, int riskTaking, Date maturity, Date expiry){
        CapitalStrategy capitalStrategy = new CapitalStrategyRevolver();
        return new Loan(capitalStrategy, commitment, 0.0, riskTaking, maturity, expiry);
    }

    public static Loan newRevolverLoan(double commitment, double outstanding, int customerRating, Date maturity, Date expiry){
        CapitalStrategy capitalStrategy = new CapitalStrategyRevolver();
        return new Loan(capitalStrategy, commitment, outstanding, customerRating, maturity, expiry);
    }

    public static Loan newRCTLLoan(CapitalStrategy capitalStrategy, double commitment, int riskTaking, Date maturity, Date expiry){
        return new Loan(capitalStrategy, commitment, 0.00, riskTaking, maturity, expiry);
    }

    private Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskTaking, Date maturity, Date expiry){
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskTaking = riskTaking;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;
    }
}

// The following classes are for illustration purpose of this exercise only. Don't do this.
class CapitalStrategy {
    
}

class CapitalStrategyTermLoan extends CapitalStrategy{

}

class CapitalStrategyRevolver extends CapitalStrategy{
    
}

class CapitalStrategyRCTL extends CapitalStrategy{

}

