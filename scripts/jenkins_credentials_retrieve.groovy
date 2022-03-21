// Markdown formatted output
def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
    com.cloudbees.plugins.credentials.Credentials.class
)

for (c in creds) {
  println("## ${c.id}")
  	println("* **id**: ${c.id}")
    println("* **class**: ${c.class}")

  	println "```bash"
    if(c.properties.secretBytes){
        String s = new String( c.getSecretBytes().getPlainData() )
        println s
    }

    if (c.properties.username) {
        println("description: " + c.description)
    }
    if (c.properties.username) {
        println("username: " + c.username)
    }
    if (c.properties.password) {
        println("password: " + c.password)
    }
    if (c.properties.passphrase) {
        println("passphrase: " + c.passphrase)
    }
    if (c.properties.secret) {
        println("secret: " + c.secret)
    }
    if (c.properties.privateKeySource) {
        println("privateKey: " + c.getPrivateKey())
    }
    if (c.properties.accessKey) {
        println("accessKey: " + c.getAccessKey())
    }
    if (c.properties.secretKey) {
        println("secretKey: " + c.getSecretKey())
    }

    println("```")
}