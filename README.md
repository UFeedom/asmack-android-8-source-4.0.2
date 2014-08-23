This is the source code of asmack(vserion 4.0.2) about Android

For more detail ,please visit https://github.com/flowdalic/asmack

Note:

Smack requires dnsjava for DNS SRV record lookup.I have add the
dnsjava library to the project's libraries.



The bosh and especially the jingle code is old and unmaintained. It may not work in all cases. Patches welcome.
 
Smack is split in various subprojects. A typical XMPP over TCP project should use the 'smack-tcp', 'smack-resolver-javax' and 'smack-extensions' subprojects. All other required dependencies are automatically pulled in. This means that such a project should depend only on org.jivesoftware.smack:smack-tcp, org.jivesoftware.smack:smack-resolver-javax and org.jivesoftware.smack:smack-extensions, as all other required dependencies are transitively resolved.
 
Changes from Smack 3.4 to 4.0
 
Renamed Connection to XMPPConnection, which is subclassed by XMPPTCPConnection and XMPPBOSHConnection. You can use find -type f -name "*.java" |xargs sed -i 's;\([^A-Za-z]\)Connection\([^A-Za-z]\);\1XMPPConnection\2;g' to rename Connection to XMPPConnection in your java code.
Moved provider and packages Classes to their respective package, i.e. org.jivesoftware.<feature>.(package|provider)
find -type f -name "*.java" |xargs sed -i 's;smackx.ServiceDiscoveryManager;smackx.disco.ServiceDiscoveryManager;'
find -type f -name "*.java" |xargs sed -i 's;smackx.packet.VCard;smackx.vcardtemp.packet.VCard;'
The keep-alive mechanism is now provided by PingManager and moved from core to extensions.
PrivacyList: toString has been reanmed to getName
You have to call Chat.close() before you drop all references to the Chat instance, or you will be leaking the Chat object until the ChatManager instance is gc'ed.
ServerTrustManager has been removed, if you want to use XMPP over SSL you may need to provide your own SSLContext to ConnectionConfiguration
Packet.setProperty() and co where moved out of smack-core into smack-extensions and the API is can now be found under org.jivesoftware.smackx.jiveproperties.
Connection.getAccountManager() is now AccountManager.getInstance(XMPPConnection)
All public API methods now return some kind of Collection instead of an Iterator.
Improved API with regard to Exceptions
The ToContains Filter was removed. Read me about it here.


The doc:
Nightly Snapshot javadoc: http://www.igniterealtime.org/builds/smack/dailybuilds/javadoc/
Nightly Snapshot Smack Documentation: http://www.igniterealtime.org/builds/smack/dailybuilds/documentation/
