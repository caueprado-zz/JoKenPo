module.exports = function(application){
	application.get('/actions', function(req, res){
		res.render("action/actions");
	});
	application.get('/actions/new-action', function(req, res){
		res.render("action/new_action");
	});
	application.post('/actions/add', function(req, res){
		application.app.controllers.action.new_action(application, req, res);
	});
}