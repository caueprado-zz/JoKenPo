module.exports = function(application){
	application.get('/rules', function(req, res){
		res.render("rules/rules");
	});
}