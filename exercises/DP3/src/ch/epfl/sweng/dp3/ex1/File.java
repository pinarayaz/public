package ch.epfl.sweng.dp3.ex1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.naming.OperationNotSupportedException;

public class File {
  private String data;

  public File(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public String getHash(HashFunction hashFunction) throws OperationNotSupportedException {
      String hashString = hashFunction.hash(data);
      return hashString;
  }
}
