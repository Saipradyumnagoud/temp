# OpenSSL Key Generation and Secure Communication

## Generate Private Key of User A
```sh
openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -pkeyopt rsa_keygen_pubexp:3 -out Private-Key-A.pem
```

## Display the Private Key of User A
```sh
cat Private-Key-A.pem
openssl pkey -in Private-Key-A.pem -text
```

## Generate the Public Key of User A
```sh
openssl pkey -in Private-Key-A.pem -out Public-Key-A.pem -pubout
```

## Display the Public Key of User A
```sh
openssl pkey -in Public-Key-A.pem -pubin -text
```

---

## Generate Private Key of User B
```sh
openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -pkeyopt rsa_keygen_pubexp:3 -out Private-Key-B.pem
```

## Display the Private Key of User B
```sh
cat Private-Key-B.pem
openssl pkey -in Private-Key-B.pem -text
```

## Generate the Public Key of User B
```sh
openssl pkey -in Private-Key-B.pem -out Public-Key-B.pem -pubout
```

## Display the Public Key of User B
```sh
openssl pkey -in Public-Key-B.pem -pubin -text
```

---

## List of Files
```sh
ls -l
```

---

## Message Digest
```sh
openssl dgst -sha1 message-ID.txt
```

## Calculate Hash and Sign the Message
```sh
openssl dgst -sha1 -sign Private-Key-A.pem -out sign-ID.bin msg.txt
```

## Encrypt the Message Using RSA with Recipient's Public Key
```sh
openssl pkeyutl -encrypt -in msg.txt -pubin -inkey Public-Key-B.pem -out ciphertext-ID.bin
```

## Decrypt the Received Ciphertext Using Private Key of User B
```sh
openssl pkeyutl -decrypt -in ciphertext-ID.bin -inkey Private-Key-B.pem -out receivedtext.txt
```

## Verify the Signature Using Public Key of User A
```sh
openssl dgst -sha1 -verify Public-Key-A.pem -signature sign-ID.bin receivedtext.txt
```

---

# Diffie-Hellman Secret Key Exchange

## Generate Diffie-Hellman Global Public Parameters
```sh
openssl genpkey -genparam -algorithm DH -out dhp.pem
```

## Display the Generated Global Public Parameters
```sh
cat dhp.pem
openssl pkeyparam -in dhp.pem -text
```

## Generate Private and Public Keys for User 1
```sh
openssl genpkey -paramfile dhp.pem -out dhkey1.pem
openssl pkey -in dhkey1.pem -text –noout
```

## Generate Private and Public Keys for User 2
```sh
openssl genpkey -paramfile dhp.pem -out dhkey2.pem
openssl pkey -in dhkey2.pem -text –noout
```

## Extract Public Keys for Exchange
```sh
openssl pkey -in dhkey1.pem -pubout -out dhpub1.pem
openssl pkey -pubin -in dhpub1.pem -text

openssl pkey -in dhkey2.pem -pubout -out dhpub2.pem
openssl pkey -pubin -in dhpub2.pem -text
```

## Derive the Shared Secret
```sh
openssl pkeyutl -derive -inkey dhkey1.pem -peerkey dhpub2.pem -out secret1.bin
openssl pkeyutl -derive -inkey dhkey2.pem -peerkey dhpub1.pem -out secret2.bin
```

## Verify the Shared Secret
```sh
cmp secret1.bin secret2.bin
xxd secret1.bin
xxd secret2.bin
```

