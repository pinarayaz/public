package ch.epfl.sweng.dp3.ex1;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class FileTest {
  @Test
  public void testFunctionality() throws OperationNotSupportedException {
    File file = new File("some data");
    HashFunction simpleHashFunction = new SimpleHashFunction();
    assertEquals("1882504547", file.getHash(simpleHashFunction));
    SHA256HashFunction sha256HashFunction = new SHA256HashFunction();
    assertEquals("1307990e6ba5ca145eb35e99182a9bec46531bc54ddf656a602c780fa0240dee",
      file.getHash(sha256HashFunction));
  }
}
