module.exports.new_action = function(application, req, res) {
    console.log(item);
	req.assert('user','@User obrigatório').notEmpty();
	req.assert('valor','valor é obrigatório').notEmpty();
	req.assert('quantidade','quantidade é obrigatório').notEmpty();

    var erros = req.validationErrors();

	if(erros){
		res.render("admin/form_add", {validacao : erros, item : item});
		return;
	}
    const request = require('request');
    
	var product = req.query;
	
	var url = "https://picpay.me/"+product.user+"/"+product.value;
	var payload = { qr_code_url: url };
	console.log(payload);
	request.post('http://192.168.43.252/addProduct', { body: url }, (err, res, body) => {
		if (err) { return console.log(err); }
		console.log("request completed");
		console.log(body);
	});
}