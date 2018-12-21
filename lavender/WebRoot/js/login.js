var WIDTH = 0;
var HEIGHT = 0;
var POINT = 35;
var canvas = null;
var context = null;
var circleArr = [];
$(function(){
	//定义画布宽高和生成点的个数
	WIDTH = document.documentElement.clientWidth;
	HEIGHT = document.documentElement.clientHeight;
	canvas = document.getElementById('Mycanvas');
	canvas.width = WIDTH,
	canvas.height = HEIGHT;
	context = canvas.getContext('2d');
	context.strokeStyle = 'rgba(0,0,0,0.02)',
	context.strokeWidth = 1,
	context.fillStyle = 'rgba(0,0,0,0.05)';
	//调用执行
	window.onload = function () {
		init();
		setInterval(function () {
			for (var i = 0; i < POINT; i++) {
				var cir = circleArr[i];
				cir.x += cir.moveX;
				cir.y += cir.moveY;
				if (cir.x > WIDTH) cir.x = 0;
				else if (cir.x < 0) cir.x = WIDTH;
				if (cir.y > HEIGHT) cir.y = 0;
				else if (cir.y < 0) cir.y = HEIGHT;
				
			}
			draw();
		}, 16);
	}
	//表单
	/* Used to provide loping animations in fallback mode */
	$('form input').bind('focus', function(){
		$('.rain, .border').addClass('end').removeClass('unfocus start');
	});
	$('form input').bind('blur', function(){
		$('.rain, .border').addClass('unfocus start').removeClass('end');
	});
	$('form input').first().delay(800).queue(function() {
		$(this).focus();
	});
})


function verification(){
	var userName = document.loginForm.userName.value;
	var userPassWord = document.loginForm.userPassWord.value;
	var userType = 0;
    if(userName == ""){
    	alert("请输入用户名");
		document.loginForm.userName.focus();
		return false;
	}
    if(userPassWord == "") {
    	alert("请输入密码");
		document.loginForm.userPassWord.focus();
		return false;
    }
//	 document.getElementById("indicator").style.display="block";
	/*$.ajax({
		type : 'POST',
		url : 'login.action',
		data : {
			"userName"	:	userName,
			"userPassWord"	:	userPassWord,
			"userType"	:	userType
		},
		error:function(xhr,status,error){
			console.log(error);
		},
		dataType : 'text',
		success : function(resp){
			var a = resp;
		}
	})*/
//	 loginService.login(document.loginForm.userName.value,document.loginForm.userPw.value,0,callback);
}

function callback(data){
    document.getElementById("indicator").style.display="none";
    if(data=="no"){
        alert("用户名或密码错误");
    }
    if(data=="yes"){
        alert("通过验证,系统登录成功");
        window.location.href="<%=path %>/loginSuccess.jsp";
    }
}
//动画函数

//线条：开始xy坐标，结束xy坐标，线条透明度
function Line (x, y, _x, _y, o) {
	this.beginX = x,
	this.beginY = y,
	this.closeX = _x,
	this.closeY = _y,
	this.o = o;
}
//点：圆心xy坐标，半径，每帧移动xy的距离
function Circle (x, y, r, moveX, moveY) {
	this.x = x,
	this.y = y,
	this.r = r,
	this.moveX = moveX,
	this.moveY = moveY;
}
//生成max和min之间的随机数,传入实参为长度和宽度
function num (max, min) {
	//如果min有值，则取其值，否则min为零
	var min = arguments[1] || 0;
	return Math.floor(Math.random()*(max-min+1)+min);
}
// 绘制原点
function drawCricle (cxt, x, y, r, moveX, moveY) {
	var circle = new Circle(x, y, r, moveX, moveY);
	cxt.beginPath();
	cxt.fillStyle = '#7CCD7C';
	cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI);
	cxt.closePath();
	cxt.fill();
	return circle;
}
//绘制线条
function drawLine (cxt, x, y, _x, _y, o) {
	var line = new Line(x, y, _x, _y, o)
	cxt.beginPath();
	cxt.strokeStyle = 'rgba(255,255,255,'+ o +')';
	cxt.moveTo(line.beginX, line.beginY);
	cxt.lineTo(line.closeX, line.closeY);
	cxt.closePath();
	cxt.stroke();

}
//初始化生成原点
function init () {
	circleArr = [];
	for (var i = 0; i < POINT; i++) {
		//context对象,点的X轴,点的Y轴,点的半径，移动的XY距离（使用num设置随机数）
		circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(8, 2), num(10, -10)/40, num(10, -10)/40));
	}
	draw();
}

//每帧绘制
function draw () {
	context.clearRect(0,0,canvas.width, canvas.height);
	for (var i = 0; i < POINT; i++) {
		drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
	}
	for (var i = 0; i < POINT; i++) {
		for (var j = 0; j < POINT; j++) {
			if (i + j < POINT) {
				var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
					B = Math.abs(circleArr[i+j].y - circleArr[i].y);
				var lineLength = Math.sqrt(A*A + B*B);
				var C = 1/lineLength*7-0.009;
				var lineOpacity = C > 0.03 ? 0.03 : C;
				if (lineOpacity > 0) {
					drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
				}
			}
		}
	}
}
