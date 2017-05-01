# blitzs - the blitz sniffer
Java WebSocket client and server for 'sniffing' Blitzortung lightning strike data and serving it to web clients.

* what it does:
  - starts a server on the specified IP address and port and opens a WebSocket to which clients can connect
  - once the server is started, it starts 'sniffing' data from the Blitzortung WebSocket server
  - once a client connects to the server, it immediately starts sending lightning strike data (JSON) to it
  
* future stuff:
  - will store lightning strike data for 10 days or so in some kind of database [sqlite? mariadb?] (maybe even more, depends on the VPS I will buy)
  - send the client a specific set of lightning strike data (let's say lightning strikes from day x)
  - ???
  
* dependencies:
  - org.java-websocket

* thanks to:
  - Blitzortung - http://en.blitzortung.org
  - Nathan Rajlich - https://github.com/TooTallNate
