/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayoutCalculator;

/**
 *
 * @author User
 */
public abstract class Line extends PayoutCalculator {
    
    public Line(PayoutCalculator payoutCalculator) {
        super(payoutCalculator.transferObject);
    }
    
}
