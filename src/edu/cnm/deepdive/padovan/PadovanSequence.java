/**
 * 
 */
package edu.cnm.deepdive.padovan;

import java.math.BigInteger;


/**
 * @author Sky Link
 *
 */
public class PadovanSequence implements Iterable<BigInteger> {
  
  private final int numTerms;
  
  public PadovanSequence(int numTerms) {
    this.numTerms = numTerms;
  }
  
  @Override
  public java.util.Iterator<BigInteger> iterator() {
    
    return new Iterator();
  }
  
  private class Iterator implements java.util.Iterator<BigInteger> {
    
    private int currentTerm = 0;
    private BigInteger p0 = BigInteger.ZERO;
    private BigInteger p1 = BigInteger.ZERO;
    private BigInteger p2 = BigInteger.ONE;
    
    @Override
    public boolean hasNext() {
      return (currentTerm < numTerms);
    }

    @Override
    public BigInteger next() {
      BigInteger next = p0.add(p1);
      p0 = p1;
      p1 = p2;
      p2 = next;
      currentTerm++;
      return next;
    }
    
  }
}
