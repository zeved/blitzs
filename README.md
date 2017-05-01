# blitzs - the blitz sniffer
Java WebSocket client and server for 'sniffing' Blitzortung lightning strike data and serving it to web clients.

* what it does:
  - starts a server on the specified IP address and port and opens a WebSocket to which clients can connect
  - once the server is started, it starts 'sniffing' data from the Blitzortung WebSocket server
  - when a client connects to the server, it immediately starts sending lightning strike data (JSON) to the clients
  
* thanks to:
  - Blitzortung: http://en.blitzortung.org
