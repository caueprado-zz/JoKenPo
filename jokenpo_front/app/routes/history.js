module.exports = function(application){
	application.get('/histories', function(req, res){
		res.render("histories/history");
	});
}