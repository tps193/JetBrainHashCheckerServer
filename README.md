This is a server which stores checksums for artifact by identifier group:name:version.
Basic logic is following:
1. Server get a request to provide checksums for artifacts by id
2. If checksum is found it is returned

This specific implementation is pretty simple and works with local H2 database saved at build folder.

Server limitations:
1. No proper logging is implemented
2. Server by default runs at 8095 port (the value is hardcoded in the plugin)
3. DTO model is not shared with the plugin but copied-pasted
4. Add checksum endpoint is added for test purposes
5. Server expects SHA-256 hashes only

Plugin might get real data for checksums for example from Maven repo.
Server data is not supposed to be updated often. It should be rather be bulk updated rarely instead.

You can find a plugin code at https://github.com/tps193/JetBrainsHashChecker