package org.talend.designer.codegen.translators.cloud.amazon.s3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3ListBeginJava
{
  protected static String nl;
  public static synchronized TS3ListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListBeginJava result = new TS3ListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_11 = NL + "    " + NL + "    \t\t";
  protected final String TEXT_12 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = "; ";
  protected final String TEXT_18 = NL + NL + "\t\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_19 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_20 = ",decryptedPassword_";
  protected final String TEXT_21 = ");" + NL + "\t\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_22 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_23 = ");" + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_25 = " = new com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper();" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tString masterKey_";
  protected final String TEXT_27 = NL + "\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_28 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(masterKey_";
  protected final String TEXT_29 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_30 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_31 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_32 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_33 = NL + "\t\t\t";
  protected final String TEXT_34 = " " + NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_35 = ");" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_37 = "; " + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_39 = " = new com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(kms_cmk_";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = " " + NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_44 = "; " + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_46 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(smk_";
  protected final String TEXT_47 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_49 = NL + "\t\t\t\tjava.io.File keyFile_";
  protected final String TEXT_50 = " = new java.io.File(";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\tjava.io.FileInputStream keyfis_";
  protected final String TEXT_52 = " = null;" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_53 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_54 = " = new java.io.FileInputStream(keyFile_";
  protected final String TEXT_55 = ");" + NL + "\t\t\t        byte[] encodedPrivateKey_";
  protected final String TEXT_56 = " = new byte[(int)keyFile_";
  protected final String TEXT_57 = ".length()];" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_58 = ".read(encodedPrivateKey_";
  protected final String TEXT_59 = ");" + NL + "\t\t\t        symmetricKey_";
  protected final String TEXT_60 = " = new javax.crypto.spec.SecretKeySpec(encodedPrivateKey_";
  protected final String TEXT_61 = ", \"AES\");" + NL + "\t\t        } finally {" + NL + "\t\t        \tif(keyfis_";
  protected final String TEXT_62 = "!=null) {" + NL + "\t\t        \t\tkeyfis_";
  protected final String TEXT_63 = ".close();" + NL + "\t\t        \t}" + NL + "\t\t        }" + NL + "\t\t        " + NL + "\t\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_64 = NL + "\t\t\tjava.io.File filePublicKey_";
  protected final String TEXT_65 = ");" + NL + "\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_66 = " = null;" + NL + "\t\t\tbyte[] encodedPublicKey_";
  protected final String TEXT_67 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t        fis_";
  protected final String TEXT_68 = " = new java.io.FileInputStream(filePublicKey_";
  protected final String TEXT_69 = ");" + NL + "\t\t        encodedPublicKey_";
  protected final String TEXT_70 = " = new byte[(int) filePublicKey_";
  protected final String TEXT_71 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_72 = ".read(encodedPublicKey_";
  protected final String TEXT_73 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_74 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_75 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.io.File filePrivateKey_";
  protected final String TEXT_76 = ");" + NL + "\t        byte[] encodedPrivateKey_";
  protected final String TEXT_77 = " = null;" + NL + "\t        try {" + NL + "\t\t        fis_";
  protected final String TEXT_78 = " = new java.io.FileInputStream(filePrivateKey_";
  protected final String TEXT_79 = ");" + NL + "\t\t        encodedPrivateKey_";
  protected final String TEXT_80 = " = new byte[(int) filePrivateKey_";
  protected final String TEXT_81 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.security.KeyFactory keyFactory_";
  protected final String TEXT_82 = " = java.security.KeyFactory.getInstance(\"";
  protected final String TEXT_83 = "\");" + NL + "\t        " + NL + "\t        java.security.spec.X509EncodedKeySpec publicKeySpec_";
  protected final String TEXT_84 = " = new java.security.spec.X509EncodedKeySpec(" + NL + "\t                encodedPublicKey_";
  protected final String TEXT_85 = ");" + NL + "\t        java.security.PublicKey publicKey_";
  protected final String TEXT_86 = " = keyFactory_";
  protected final String TEXT_87 = ".generatePublic(publicKeySpec_";
  protected final String TEXT_88 = ");" + NL + "\t" + NL + "\t        java.security.spec.PKCS8EncodedKeySpec privateKeySpec_";
  protected final String TEXT_89 = " = new java.security.spec.PKCS8EncodedKeySpec(" + NL + "\t                encodedPrivateKey_";
  protected final String TEXT_90 = ");" + NL + "\t        java.security.PrivateKey privateKey_";
  protected final String TEXT_91 = ".generatePrivate(privateKeySpec_";
  protected final String TEXT_92 = ");" + NL + "\t" + NL + "\t        java.security.KeyPair asymmetricKey_";
  protected final String TEXT_93 = " = new java.security.KeyPair(publicKey_";
  protected final String TEXT_94 = ", privateKey_";
  protected final String TEXT_95 = ");" + NL + "\t        " + NL + "\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_96 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(asymmetricKey_";
  protected final String TEXT_97 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_98 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\tcc_";
  protected final String TEXT_99 = ".setUserAgent(\"";
  protected final String TEXT_100 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_101 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_102 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_104 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_106 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_107 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_108 = ".set";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = NL + "\t\t\t\tcc_";
  protected final String TEXT_111 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_112 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_113 = NL + "\t\t\tint sessionDurationSeconds_";
  protected final String TEXT_114 = " * 60;" + NL + "\t\t\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder stsBuilder_";
  protected final String TEXT_115 = " = " + NL + "\t\t\t\t\tnew com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder(";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = ").withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_118 = ")" + NL + "\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_121 = ".withServiceEndpoint(";
  protected final String TEXT_122 = NL + "\t\t\tstsBuilder_";
  protected final String TEXT_123 = ".withClientConfiguration(cc_";
  protected final String TEXT_124 = ");" + NL + "\t\t\t" + NL + "\t\t\tcredentialsProvider_";
  protected final String TEXT_125 = " = stsBuilder_";
  protected final String TEXT_126 = ".build();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3 conn_";
  protected final String TEXT_128 = " = com.amazonaws.services.s3.AmazonS3EncryptionClientBuilder.standard()" + NL + "\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t        " + NL + "\t\t\t            ";
  protected final String TEXT_130 = NL + "\t\t\t            .withEndpointConfiguration(new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(";
  protected final String TEXT_131 = ",null))" + NL + "\t\t\t            .withForceGlobalBucketAccessEnabled(true)" + NL + "\t\t\t            ";
  protected final String TEXT_132 = ",";
  protected final String TEXT_133 = "))" + NL + "\t\t\t            ";
  protected final String TEXT_134 = NL + "\t\t\t        " + NL + "\t\t            ";
  protected final String TEXT_135 = NL + "\t\t            " + NL + "\t\t            \t";
  protected final String TEXT_136 = NL + "\t\t\t\t        .withRegion(\"us-east-1\") // The first region to try your request against" + NL + "                        .withForceGlobalBucketAccessEnabled(true) // If a bucket is in a different region, try again in the correct region";
  protected final String TEXT_137 = NL + "                        .withRegion(";
  protected final String TEXT_138 = ")";
  protected final String TEXT_139 = NL + "\t\t            " + NL + "\t\t            ";
  protected final String TEXT_140 = NL + "                    .withAccelerateModeEnabled(true)";
  protected final String TEXT_141 = NL + "                    .withCredentials(credentialsProvider_";
  protected final String TEXT_142 = ")" + NL + "                    .withClientConfiguration(cc_";
  protected final String TEXT_143 = ")" + NL + "                    .withEncryptionMaterials(encryptionMaterialsProvider_";
  protected final String TEXT_144 = NL + "                    .withCryptoConfiguration(new com.amazonaws.services.s3.model.CryptoConfiguration().withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_145 = ")))" + NL + "\t\t\t\t\t";
  protected final String TEXT_146 = NL + "                    .build();" + NL + "\t\t\t";
  protected final String TEXT_147 = " = com.amazonaws.services.s3.AmazonS3ClientBuilder.standard()" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL;
  protected final String TEXT_149 = ")" + NL + "                    .build();" + NL + "\t\t\t";
  protected final String TEXT_150 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_151 = NL + NL + "\tint nb_bucket_";
  protected final String TEXT_152 = " = 0;" + NL + "\tint nb_bucket_object_";
  protected final String TEXT_153 = " = 0;" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\t\tjava.util.List<com.amazonaws.services.s3.model.Bucket> buckets_";
  protected final String TEXT_155 = " = conn_";
  protected final String TEXT_156 = ".listBuckets();" + NL + "\t\t\tfor (com.amazonaws.services.s3.model.Bucket bucket_";
  protected final String TEXT_157 = " : buckets_";
  protected final String TEXT_158 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_159 = " = bucket_";
  protected final String TEXT_160 = ".getName();" + NL + "\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_162 = " - Retrieving objects from:\" + currentBucketName_";
  protected final String TEXT_163 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_165 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_166 = ".listObjects(currentBucketName_";
  protected final String TEXT_167 = ");" + NL + "\t\t\t\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_168 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_170 = " - Failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_171 = ");" + NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_172 = " - \"+e_";
  protected final String TEXT_173 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_175 = "] failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_176 = ");" + NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_177 = "] \"+e_";
  protected final String TEXT_178 = NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_179 = NL + "\t\t\tjava.util.List<java.util.Map<String,String>> buckets_map_list_";
  protected final String TEXT_180 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t\tjava.util.Map<String,String> bucket_prefix_map_";
  protected final String TEXT_181 = " = null;" + NL + "\t\t\tString object_prefix_";
  protected final String TEXT_182 = " = \"\";" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\tobject_prefix_";
  protected final String TEXT_184 = NL + "\t\t\t\tbucket_prefix_map_";
  protected final String TEXT_185 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\tbucket_prefix_map_";
  protected final String TEXT_186 = ".put(";
  protected final String TEXT_187 = ",object_prefix_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\tbuckets_map_list_";
  protected final String TEXT_189 = ".add(bucket_prefix_map_";
  protected final String TEXT_190 = ");" + NL + "\t\t\t\tobject_prefix_";
  protected final String TEXT_191 = NL + "\t\t\tfor (java.util.Map<String,String> bucketMap_";
  protected final String TEXT_192 = ": buckets_map_list_";
  protected final String TEXT_193 = " = \"\";" + NL + "\t\t\t\tString currentPrefix_";
  protected final String TEXT_194 = " = \"\";" + NL + "\t\t\t\tfor(java.util.Map.Entry<String,String> entry_";
  protected final String TEXT_195 = ":bucketMap_";
  protected final String TEXT_196 = ".entrySet()){" + NL + "\t\t\t\t\tcurrentBucketName_";
  protected final String TEXT_197 = " = entry_";
  protected final String TEXT_198 = ".getKey();" + NL + "\t\t\t\t\tcurrentPrefix_";
  protected final String TEXT_199 = ".getValue();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_200 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_202 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_204 = ",currentPrefix_";
  protected final String TEXT_205 = NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\twhile(true){" + NL + "\t\t\t\t\tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> list_objects_";
  protected final String TEXT_207 = " = objects_";
  protected final String TEXT_208 = ".getObjectSummaries();" + NL + "\t\t\t\t\tif(list_objects_";
  protected final String TEXT_209 = ".size()>0){" + NL + "\t\t\t\t\t\tnb_bucket_";
  protected final String TEXT_210 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (com.amazonaws.services.s3.model.S3ObjectSummary objectSummary_";
  protected final String TEXT_211 = " : list_objects_";
  protected final String TEXT_212 = ") {" + NL + "\t\t\t\t\t\tnb_bucket_object_";
  protected final String TEXT_213 = "++;" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_214 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_216 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_217 = ".getKey());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_219 = " - Retrieving the object \" + nb_bucket_object_";
  protected final String TEXT_220 = " + \".\");" + NL + "\t\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_221 = " - Key of current object : \" + objectSummary_";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean useRegionEndpoint 	= "true".equals(ElementParameterParser.getValue(node, "__USE_REGION_ENDPOINT__"));
	String regionEndpoint 		= ElementParameterParser.getValue(node,"__REGION_ENDPOINT__");
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	String arn = ElementParameterParser.getValue(node,"__ARN__");
	String roleSessionName = ElementParameterParser.getValue(node,"__ROLE_SESSION_NAME__");
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node,"__SET_STS_ENDPOINT__"));
	String stsEndpoint = ElementParameterParser.getValue(node,"__STS_ENDPOINT__");
	
	boolean enableAccelerateMode = "true".equals(ElementParameterParser.getValue(node,"__ENABLE_ACCELERATE__"));
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));
	final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		}
		
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    	
    stringBuffer.append(TEXT_11);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		} else {
		
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		}
		
		boolean encrypt = "true".equals(ElementParameterParser.getValue(node,"__ENCRYPT__"));
		
		//work for tRedshiftOutputBulk
		String encryptionKeyPropertyName = "__ENCRYPTED_KEY__";
		
		//work for s3 components
		String key_type = ElementParameterParser.getValue(node,"__KEY_TYPE__");
		String algorithm_symmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_SYMMETRIC_MASTER_KEY__");
		String algorithm_asymmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_ASYMMETRIC_MASTER_KEY__");
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String encrypted_key_x509 = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY_X509__");
		String public_key = ElementParameterParser.getValue(node,"__PUBLIC_KEY__");
		String private_key = ElementParameterParser.getValue(node,"__PRIVATE_KEY__");
		
		if(encrypt && node.getComponent().getName().startsWith("tRedshift")) {
			if (ElementParameterParser.canEncrypt(node, encryptionKeyPropertyName)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, encryptionKeyPropertyName));
    stringBuffer.append(TEXT_14);
    
			} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, encryptionKeyPropertyName) );
    stringBuffer.append(TEXT_17);
    
			}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		} else if(encrypt && "KMS_CMK".equals(key_type)) {//KMS
		
    stringBuffer.append(TEXT_33);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_CMK__")) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		} else if(encrypt && "SYMMETRIC_MASTER_KEY".equals(key_type)) {//symmetric master key
			if("AES".equals(algorithm_symmetric_master_key) && "BASE64".equals(encoding)) {
			
    stringBuffer.append(TEXT_40);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_BASE64__")) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			} else if("AES".equals(algorithm_symmetric_master_key) && "X509".equals(encoding)) {
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(encrypted_key_x509);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			}
		} else if(encrypt && "ASYMMETRIC_MASTER_KEY".equals(key_type)) {//asymmetric master key
		
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(public_key);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(private_key);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(algorithm_asymmetric_master_key);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		}
		
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_5);
    
		if(configClient && clientConfiguration.size()>0){
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_104);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_104);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_42);
    
				}else{
				
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_42);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			}
			
		}
		
		if(assumeRole) {
		
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
			if(setStsEndpoint) {
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_35);
    
			}
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
		}
			if(encrypt) {
			
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if(useRegionEndpoint && regionEndpoint != null && !regionEndpoint.isEmpty()){
    stringBuffer.append(TEXT_129);
    if(!set_region){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_131);
    }else{
    stringBuffer.append(TEXT_130);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    }else{
    stringBuffer.append(TEXT_135);
    if(!set_region){
    stringBuffer.append(TEXT_136);
    }else{
    stringBuffer.append(TEXT_137);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    }
    if(enableAccelerateMode){
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_144);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    
			} else {
			
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    if(useRegionEndpoint && regionEndpoint != null && !regionEndpoint.isEmpty()){
    stringBuffer.append(TEXT_129);
    if(!set_region){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_131);
    }else{
    stringBuffer.append(TEXT_130);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    }else{
    stringBuffer.append(TEXT_135);
    if(!set_region){
    stringBuffer.append(TEXT_136);
    }else{
    stringBuffer.append(TEXT_137);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_148);
    if(enableAccelerateMode){
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
			}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
		}
	}
	
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
		List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
		boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
		if(listAll){
			String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
			
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
				}
				
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(objects_prefix!=null && objects_prefix.trim().length()>0 ?objects_prefix:null);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
					}else{
			    	
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
					}
					
    stringBuffer.append(TEXT_178);
    
		} else if(buckets.size()>0){
		
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
			for(Map<String, String> map: buckets){
				String bucket_name =map.get("BUCKET_NAME");
				String object_prefix =map.get("OBJECT_PREFIX");
				if(object_prefix!=null && object_prefix.trim().length()>0){
				
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_104);
    
				}
				
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
			}
			
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
					}
					
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
					}else{
			    	
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
					}
					
    stringBuffer.append(TEXT_205);
    
			}
			if(listAll || buckets.size()>0){
			
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
						}
						
    stringBuffer.append(TEXT_33);
    
			}
			
    return stringBuffer.toString();
  }
}
