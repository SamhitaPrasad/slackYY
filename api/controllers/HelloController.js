/**
 * ChatController
 *
 * @description :: Server-side logic for managing Chats
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
  
  sendMessage: function(req, res) {
    // Make sure this is a socket request (not traditional HTTP)
    if (!req.isSocket) {
      return res.badRequest();
    }
    
    const channelName = req.param('channelName');
    const channelId = req.param('channelId');
    const msg = req.param('msg');
    console.log('dfa', channelName, channelId, msg);
    sails.sockets.broadcast(channelName, 'chatBroadcast', { channelId: channelId, msg: msg });
    
    return res.json({
      anyData: 'from send msg'
    });
  },

  hello: function(req, res) {

    // Make sure this is a socket request (not traditional HTTP)
    if (!req.isSocket) {
      return res.badRequest();
    }

    const channelName = req.param('channelName');
    console.log('data dump', channelName);
    // Have the socket which made the request join the room.
    sails.sockets.join(req, channelName);

    // Broadcast a notification to all the sockets who have joined
    // the "funSockets" room, excluding our newly added socket:
    /* TODO: Add notification */
    sails.sockets.broadcast(channelName, 'chatBroadcast', { howdy: 'hi there!'});

    // ^^^
    // At this point, we've blasted out a socket message to all sockets who have
    // joined the "funSockets" room.  But that doesn't necessarily mean they
    // are _listening_.  In other words, to actually handle the socket message,
    // connected sockets need to be listening for this particular event (in this
    // case, we broadcasted our message with an event name of "hello").  The
    // client-side you'd need to write looks like this:
    // 
    // io.socket.on('hello', function (broadcastedData){
    //   console.log(data.howdy);
    //   // => 'hi there!'
    // }
    // 

    // Now that we've broadcasted our socket message, we still have to continue on
    // with any other logic we need to take care of in our action, and then send a
    // response.  In this case, we're just about wrapped up, so we'll continue on

    // Respond to the request with a 200 OK.
    // The data returned here is what we received back on the client as `data` in:
    // `io.socket.get('/say/hello', function gotResponse(data, jwRes) { /* ... */ });`
    return res.json({
      anyData: 'we want to send back'
    });

  }
};

