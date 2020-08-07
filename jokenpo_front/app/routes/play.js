module.exports = function(application){
	application.get('/play', function(req, res){
		res.render("play/select-player");
	});

	// module.exports = function(application){
	// 	application.get('/play', function(req, res){
	// 		res.render("play/play");
	// 	});
	// }

	application.post('/play/names', function(req, res){
		console.log(req.body)
		res.render("play/play", { value : req.body.player });
	});
}