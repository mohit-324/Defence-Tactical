package com.defence.tactical.core.ports.outbound;

public interface CryptoPort {
    byte[] encrypt(byte[] payload);
    byte[] decrypt(byte[] cipherText);
}
