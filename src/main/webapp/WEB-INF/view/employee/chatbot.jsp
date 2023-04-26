<%@page import="com.demo.utils.BaseMethods"%>
<style>
.reciver_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.reciver_box, .sender_box {
	padding: 0px 25px;
}

.reciver_logo {
	float: left;
	margin-right: 20px;
}

.sender_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.reciver_box, .sender_box {
	padding: 0px 25px;
}

.sender_logo {
	float: right;
	margin-left: 20px;
}

.sender_chat {
	float: right;
	width: 65%;
}

.senderchat-pane {
	background: #0072bb;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	line-height: 25px;
}

.reciverchat-pane {
	background: #edf5fa;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #686c6e;
	font-size: 16px;
	line-height: 25px;
}

.reciver_chat {
	float: left;
	width: 75%;
}

.panel-body {
	display: block;
	height: 200px;
	overflow: auto;
	position: -webkit-sticky;
	position: sticky;
	bottom: 0;
}

.owl-item:active {
	width: 10%;
}
</style>
<style type="text/css">
#slider-text {
	padding-top: 40px;
	display: block;
}

#slider-text .col-md-6 {
	overflow: hidden;
}

#slider-text h2 {
	font-family: 'Josefin Sans', sans-serif;
	font-weight: 400;
	font-size: 30px;
	letter-spacing: 3px;
	margin: 30px auto;
	padding-left: 40px;
}

#slider-text h2::after {
	border-top: 2px solid #c7c7c7;
	content: "";
	position: absolute;
	bottom: 35px;
	width: 100%;
}

#itemslider h4 {
	font-family: 'Josefin Sans', sans-serif;
	font-weight: 400;
	font-size: 12px;
	margin: 10px auto 3px;
}

#itemslider h5 {
	font-family: 'Josefin Sans', sans-serif;
	font-weight: bold;
	font-size: 12px;
	margin: 3px auto 2px;
}

#itemslider h6 {
	font-family: 'Josefin Sans', sans-serif;
	font-weight: 300;;
	font-size: 10px;
	margin: 2px auto 5px;
}

.badge {
	background: #b20c0c;
	position: absolute;
	height: 40px;
	width: 40px;
	border-radius: 50%;
	line-height: 31px;
	font-family: 'Josefin Sans', sans-serif;
	font-weight: 300;
	font-size: 14px;
	border: 2px solid #FFF;
	box-shadow: 0 0 0 1px #b20c0c;
	top: 5px;
	right: 25%;
}

.itmename {
	text-align: center;
	margin-left: 50px !important;
	margin-right: 50px !important;
	background-color: #447BA8;
	color: #FFFFFF;
	border: 1px solid #FFFFFF;
	white-space: nowrap;
	display: block;
	margin-left: 6px;
	margin-right: 6px;
	font-size: 16px;
	font-weight: 700;
	font-size: 16px;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	padding: 6px 12px;
	border-radius: 3px;
}

#slider-control img {
	padding-top: 60%;
	margin: 0 auto;
}

@media screen and (max-width: 992px) {
	#slider-control img {
		padding-top: 70px;
		margin: 0 auto;
	}
}

.carousel-showmanymoveone .carousel-control {
	width: 4%;
	background-image: none;
}

.carousel-showmanymoveone .carousel-control.left {
	margin-left: 5px;
}

.carousel-showmanymoveone .carousel-control.right {
	margin-right: 5px;
}

.carousel-showmanymoveone .cloneditem-1, .carousel-showmanymoveone .cloneditem-2,
	.carousel-showmanymoveone .cloneditem-3, .carousel-showmanymoveone .cloneditem-4,
	.carousel-showmanymoveone .cloneditem-5 {
	display: none;
}

@media all and (min-width: 768px) {
	.carousel-showmanymoveone .carousel-inner>.active.left,
		.carousel-showmanymoveone .carousel-inner>.prev {
		left: -50%;
	}
	.carousel-showmanymoveone .carousel-inner>.active.right,
		.carousel-showmanymoveone .carousel-inner>.next {
		left: 50%;
	}
	.carousel-showmanymoveone .carousel-inner>.left,
		.carousel-showmanymoveone .carousel-inner>.prev.right,
		.carousel-showmanymoveone .carousel-inner>.active {
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner .cloneditem-1 {
		display: block;
	}
}

@media all and (min-width: 768px) and (transform-3d) , all and
	(min-width: 768px) and (-webkit-transform-3d) {
	.carousel-showmanymoveone .carousel-inner>.item.active.right,
		.carousel-showmanymoveone .carousel-inner>.item.next {
		-webkit-transform: translate3d(50%, 0, 0);
		transform: translate3d(50%, 0, 0);
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner>.item.active.left,
		.carousel-showmanymoveone .carousel-inner>.item.prev {
		-webkit-transform: translate3d(-50%, 0, 0);
		transform: translate3d(-50%, 0, 0);
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner>.item.left,
		.carousel-showmanymoveone .carousel-inner>.item.prev.right,
		.carousel-showmanymoveone .carousel-inner>.item.active {
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
		left: 0;
	}
}

@media all and (min-width: 992px) {
	.carousel-showmanymoveone .carousel-inner>.active.left,
		.carousel-showmanymoveone .carousel-inner>.prev {
		left: -16.666%;
	}
	.carousel-showmanymoveone .carousel-inner>.active.right,
		.carousel-showmanymoveone .carousel-inner>.next {
		left: 16.666%;
	}
	.carousel-showmanymoveone .carousel-inner>.left,
		.carousel-showmanymoveone .carousel-inner>.prev.right,
		.carousel-showmanymoveone .carousel-inner>.active {
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner .cloneditem-2,
		.carousel-showmanymoveone .carousel-inner .cloneditem-3,
		.carousel-showmanymoveone .carousel-inner .cloneditem-4,
		.carousel-showmanymoveone .carousel-inner .cloneditem-5,
		.carousel-showmanymoveone .carousel-inner .cloneditem-6 {
		display: block;
	}
}

@media all and (min-width: 992px) and (transform-3d) , all and
	(min-width: 992px) and (-webkit-transform-3d) {
	.carousel-showmanymoveone .carousel-inner>.item.active.right,
		.carousel-showmanymoveone .carousel-inner>.item.next {
		-webkit-transform: translate3d(16.666%, 0, 0);
		transform: translate3d(16.666%, 0, 0);
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner>.item.active.left,
		.carousel-showmanymoveone .carousel-inner>.item.prev {
		-webkit-transform: translate3d(-16.666%, 0, 0);
		transform: translate3d(-16.666%, 0, 0);
		left: 0;
	}
	.carousel-showmanymoveone .carousel-inner>.item.left,
		.carousel-showmanymoveone .carousel-inner>.item.prev.right,
		.carousel-showmanymoveone .carousel-inner>.item.active {
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
		left: 0;
	}
}
</style>
<style>
.reciver_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.reciver_box, .sender_box {
	padding: 0px 25px;
}

.reciver_logo {
	float: left;
	margin-right: 20px;
}

.sender_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.reciver_box, .sender_box {
	padding: 0px 25px;
}

.sender_logo {
	float: right;
	margin-left: 20px;
}

.sender_chat {
	float: right;
	width: 65%;
}

.senderchat-pane {
	background: #0072bb;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	line-height: 25px;
}

.reciverchat-pane {
	background: #edf5fa;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #686c6e;
	font-size: 16px;
	line-height: 25px;
}

.reciver_chat {
	float: left;
	width: 65%;
}

.panel-body {
	display: block;
	height: 200px;
	overflow: auto;
	position: -webkit-sticky;
	position: sticky;
	bottom: 0;
}
</style>

<style>
.chat-launcher {
	position: fixed;
	bottom: 20px;
	right: 20px;
	width: 50px;
	height: 50px;
	z-index: 9999;
	color: #fff;
	border-radius: 50%;
	cursor: pointer;
	box-shadow: 0 0 6px rgba(0, 0, 0, 0.16), 0 6px 12px rgba(0, 0, 0, 0.32)
}

.chat-launcher:before, .chat-launcher:after {
	font-family: "Material-Design-Iconic-Font";
	font-size: 23px;
	position: absolute;
	right: 17px;
	top: 8px;
	-webkit-transition: transform 180ms linear, opacity 130ms linear;
	transition: transform 180ms linear, opacity 130ms linear
}

.chat-launcher:before {
	content: "\f266";
	opacity: 1;
	-webkit-transform: rotate(0deg) scale(1);
	transform: rotate(0deg) scale(1)
}

.chat-launcher:after {
	content: "\f136";
	opacity: 0;
	-webkit-transform: rotate(-30deg);
	transform: rotate(-30deg)
}

.chat-launcher:hover {
	background: #ffb329
}

.chat-launcher.active:before {
	opacity: 0;
	-webkit-transform: rotate(70deg) scale(0);
	transform: rotate(70deg) scale(0)
}

.chat-launcher.active:after {
	opacity: 1;
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg)
}

.chat-wrapper {
	width: 385px;
	position: fixed;
	right: 40px;
	bottom: 40px;
	z-index: 999;
	-webkit-transition: transform 400ms ease;
	transition: transform 400ms ease;
	-webkit-transform: translateY(130%);
	transform: translateY(130%)
}

.chat-wrapper.is-open {
	-webkit-transform: translateY(0);
	transform: translateY(0)
}

.chat-wrapper .card {
	margin: 0;
	padding: 15px;
	border-radius: 10px;
	box-shadow: 1px 1px 100px 2px rgba(0, 0, 0, 0.22)
}

.chat-wrapper .card .header {
	border-radius: 10px 10px 0 0
}

@font-face {
	font-family: 'Helvetica Neue';
	src: url('../fonts/HelveticaNeue.eot');
	src: url('../fonts/HelveticaNeue.eot?#iefix')
		format('embedded-opentype'), url('../fonts/HelveticaNeue.woff2')
		format('woff2'), url('../fonts/HelveticaNeue.woff') format('woff'),
		url('../fonts/HelveticaNeue.ttf') format('truetype'),
		url('../fonts/HelveticaNeue.svg#HelveticaNeue') format('svg');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'HelveticaNeuebold';
	src: url('../fonts/HelveticaNeue-Bold.eot');
	src: url('../fonts/HelveticaNeue-Bold.eot?#iefix')
		format('embedded-opentype'), url('../fonts/HelveticaNeue-Bold.woff2')
		format('woff2'), url('../fonts/HelveticaNeue-Bold.woff')
		format('woff'), url('../fonts/HelveticaNeue-Bold.ttf')
		format('truetype'),
		url('../fonts/HelveticaNeue-Bold.svg#HelveticaNeue-Bold')
		format('svg');
	font-weight: bold;
	font-style: normal;
}

body {
	font-family: 'Helvetica Neue';
	background: #ebeff2;
	margin: 0;
	padding: 0;
}

.chat_box {
	max-width: 460px;
	width: 100%;
	bottom: 20px;
	position: fixed;
	float: right;
	right: 40px;
	-webkit-box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.26);
	-moz-box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.26);
	box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.26);
	border-radius: 12px;
}

.chat_header {
	background: #0072bb;
	padding: 20px;
	border-top-left-radius: 12px;
	border-top-right-radius: 12px;
	color: #fff;
	background-image: -moz-linear-gradient(90deg, rgb(57, 145, 202) 0%,
		rgb(92, 128, 181) 100%);
	background-image: -webkit-linear-gradient(90deg, rgb(57, 145, 202) 0%,
		rgb(92, 128, 181) 100%);
	background-image: -ms-linear-gradient(90deg, rgb(57, 145, 202) 0%,
		rgb(92, 128, 181) 100%);
}

.chat_header h5 {
	text-align: center;
	font-family: 'Helvetica Neue';
	margin: -18px 0 0px 0;
	font-size: 18px;
	letter-spacing: 1px;
}

.chat_header p {
	text-align: center;
	margin: 20px 40px 0px 40px;
	font-size: 14px;
	padding: 0px 0 15px;
	line-height: 25px;
	border-bottom: 1px solid #50a1d4;
}

.chat_header h6 {
	font-weight: normal;
	text-align: center;
	font-size: 16px;
	margin: 20px 0px 0px;
}

.chat_room {
	padding: 0px 0px 0px 0px;
	max-height: 300px;
	overflow-x: hidden;
	background: #fff;
}

.chating_area {
	padding-top: 30px
}

.reciver_box, .sender_box {
	padding: 0px 25px;
}

.reciver_logo {
	float: left;
	margin-right: 20px;
}

.reciver_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.sender_box_outer {
	float: left;
	width: 100%;
	margin-bottom: 10px;
}

.sender_logo {
	float: right;
	margin-left: 20px;
}

.reciver_chat {
	float: left;
	width: 65%;
}

.sender_chat {
	float: right;
	width: 65%;
}

.reciverchat-pane {
	background: #edf5fa;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #686c6e;
	font-size: 16px;
	line-height: 25px;
}

.reciverchat-pane span {
	color: #b8bec2;
}

.senderchat-pane span {
	color: #4b9bcf;
}

.senderchat-pane {
	background: #0072bb;
	padding: 15px 20px;
	position: relative;
	margin-bottom: 5px;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	line-height: 25px;
}

.reciverchat-pane.first:before {
	content: "";
	position: absolute;
	top: 0;
	left: -10px;
	width: 0;
	height: 0;
	border: 6px solid #edf5fa;
	border-left-color: rgba(0, 0, 0, 0);
	border-bottom-color: rgba(0, 0, 0, 0);
}

.senderchat-pane.first:before {
	content: "";
	position: absolute;
	top: 0;
	right: -10px;
	width: 0;
	height: 0;
	border: 6px solid #0072bb;
	border-right-color: rgba(0, 0, 0, 0);
	border-bottom-color: rgba(0, 0, 0, 0);
}

.crousel_area {
	float: left;
	width: 100%;
	padding-bottom: 10px;
}

.inner_content {
	background: #edf5fa;
	border-radius: 4px;
	padding: 10px;
	color: #686c6e;
	font-size: 14px;
	line-height: 20px;
}

.owl-carousel .owl-nav .owl-next, .owl-carousel .owl-nav .owl-prev {
	width: 22px;
	height: 40px;
	margin-top: -20px;
	position: absolute;
	top: 50%;
}

.owl-carousel .owl-nav .owl-prev {
	left: 0px;
}

.owl-carousel .owl-nav .owl-next {
	right: 5px;
}

.mCSB_scrollTools .mCSB_dragger .mCSB_dragger_bar {
	/* background-color: #d4dbdf !important;*/
	width: 7px !important;
	background-color: rgba(212, 219, 223, 0.7) !important;
}

.mCSB_inside>.mCSB_container {
	margin-right: 10px !important;
}

.mCSB_scrollTools .mCSB_draggerRail {
	background: transparent !important;
}

.padding-crousel {
	padding: 0 0px;
}

.chat_form {
	padding: 12px;
	background: #ebeff2;
	overflow: hidden;
}

input.submit_btn {
	background: url(../images/snd_nor.png);
	background-repeat: no-repeat;
	width: 26px;
	height: 22px;
	border: 0;
	position: relative;
	top: -4px;
	padding: 20px;
	cursor: pointer;
	box-shadow: 0px 10px 10px 0px rgba(0, 0, 0, 0.1);
	border-radius: 50px;
}

input.submit_btn:hover {
	background: url(../images/snd_hov.png);
	box-shadow: 0px 10px 10px 0px rgba(0, 0, 0, 0.1);
}

input.submit_btn:active {
	background: url(../images/snd_pressed.png);
	box-shadow: none;
}

.chat_form input[type="text"] {
	border: none;
	padding: 12px 12px 12px 50px;
	width: 99%;
	font-size: 16px;
	color: #b1b7ba;
	border-radius: 50px;
	background: url(../images/dropdown.png) no-repeat center right 20px #fff;
}

.chat_form span img {
	position: relative;
	top: 7px;
	opacity: 0.5;
}

.chat_form span img:hover {
	opacity: 1;
}

.record {
	position: relative;
}

.record a {
	background: url(../images/s_nor.png) no-repeat center;
	width: 40px;
	height: 40px;
	float: left;
	position: absolute;
	border-radius: 50px;
	left: 2px;
	top: -12px;
	box-shadow: 0px 10px 10px 0px rgba(0, 0, 0, 0.1);
}

.mute a {
	background: url(../images/spk_nor.png) no-repeat center;
	width: 40px;
	height: 40px;
	float: right;
}

.mute a:hover {
	background: url(../images/spk_hov.png) no-repeat center;
}

.mute a.active {
	background: url(../images/spk_on.png) no-repeat center;
}

.record a:hover {
	background: url(../images/s_hov.png) no-repeat center;
}

.record a:active {
	background: url(../images/s_pressed.png) no-repeat center;
	box-shadow: none;
}

.send_outer {
	margin: 0 2px;
}

.pannel_setting {
	float: right;
}

.minimize {
	position: relative;
	bottom: 6px;
	margin-right: 10px;
}

::-webkit-input-placeholder { /* Chrome/Opera/Safari */
	color: #b1b7ba;
}

::-moz-placeholder { /* Firefox 19+ */
	color: #b1b7ba;
}

:-ms-input-placeholder { /* IE 10+ */
	color: #b1b7ba;
}

:-moz-placeholder { /* Firefox 18- */
	color: #b1b7ba;
}

.panel-body-content .nav>li>a {
	padding: 4px 7px;
}

.panel-body-content .content-box-sub-h {
	font-size: 18px;
}

.panel-body-content .panel-default {
	border: none;
	margin: 0px;
}

.panel-body-content .panel-body {
	min-height: 330px;
	margin-top: 20px;
}

.panel-body-content .panel-default>.panel-heading {
	padding-bottom: 0px;
	background: none;
	border: none;
}

.panel-body-content #carousel {
	margin-top: 0px;
}

.panel-body-content .owl-carousel .owl-stage-outer {
	padding: 10px;
}

.panel-body-content .widget-chat-text-message-item.widget-chat-message-item-server.widget-chat-message-item-server-center
	{
	background-color: #447BA8;
	color: #FFFFFF;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	font-size: 16px;
	padding: 6px 12px;
	border-radius: 3px;
	max-width: 75%;
	margin: 0 auto 30px;
}

.panel-body-content .widget-chat-buttons .widget-chat-button-item-question
	{
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	font-size: 16px;
	background-color: white;
	padding: 6px 12px;
}

.panel-body-content .widget-chat-quick-reply-item {
	white-space: nowrap;
	display: block;
	margin-left: 6px;
	margin-right: 6px;
	font-family: "Source Sans Pro", sans-serif !important;
	font-size: 16px;
	font-weight: 700;
	color: #000;
	font-size: 16px;
	background-color: white;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	padding: 6px 12px;
	border: 1px solid green;
	border-radius: 3px;
	cursor: pointer;
}

.panel-body-content .widget-chat-quick-reply-item {
	background-color: #447BA8;
	color: #FFFFFF;
	border: 1px solid #FFFFFF;
}

.panel-body-content .widget-chat-quick-reply-item:hover {
	background-color: #FFFFFF;
	color: #447BA8;
	border: 1px solid #447BA8;
}

.panel-body-content .widget-chat-buttons .widget-chat-button-item-question
	{
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	font-size: 16px;
	background-color: white;
	padding: 6px 12px;
}

.panel-body-content .widget-chat-buttons {
	position: relative;
	margin: 0 auto;
	width: 60%;
}

.panel-body-content .widget-chat-buttons .widget-chat-button-item {
	display: block;
	width: 100%;
	text-align: center;
	font-family: "Source Sans Pro", sans-serif !important;
	font-size: 16px;
	font-weight: 700;
	color: #000;
	background: white;
	background-color: white;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	border: 0;
	margin: 10px 0;
	padding: 10px 10px;
	cursor: pointer;
}

.panel-body-content .widget-chat-buttons .widget-chat-button-item {
	background-color: #447BA8;
	color: #FFFFFF;
}

.panel-body-content .widget-chat-list .widget-chat-list-item {
	margin-top: 10px;
	margin-top: 6px;
	overflow: hidden;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
}

.panel-body-content .item-content .widget-chat-list-item-content-description
	{
	padding: 10px 10px;
}

.panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content .widget-chat-list-item-content-description
	{
	padding: 10px 10px;
}

.panel-body-content #Quickreply .owl-carousel.owl-drag .owl-item {
	width: 110px !important;
}

.panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content
	{
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-justify-content: space-between;
	-ms-flex-pack: justify;
	justify-content: space-between;
}

.panel-body-content .widget-chat-messages {
	font-weight: 700;
	font-size: 16px;
	color: #000;
}

.panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content .widget-chat-list-item-content-description .widget-chat-list-item-content-description-button
	{
	border: 1px solid green;
	background-color: white;
	border-radius: 3px;
	font-size: 16px;
	color: #000;
	padding: 6px 12px;
	font-weight: 700;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	cursor: pointer;
	margin-top: 10px;
}

.panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content .widget-chat-list-item-content-description .widget-chat-list-item-content-description-button
	{
	background-color: #447BA8;
	color: #FFFFFF;
	border: 1px solid #FFFFFF;
}

.get-start {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.7);
	text-align: center;
	padding-top: 48%;
	z-index: 9999;
	color: #fff;
}

.get-start span {
	background: #0072bb;
	display: inline-block;
	padding: 8px 20px;
	cursor: pointer;
}

.chat_form span.left-input {
	float: left;
	width: 85%
}

.chat_form .send_outer {
	float: left;
	width: 8%;
	margin-top: 7px;
}

.panel-body-content .widget-chat-carousel-item-content {
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
}

.panel-body-content .widget-chat-carousel-item-content-image {
	height: 120px;
	width: 100%;
	overflow: hidden;
}

.panel-body-content .widget-chat-carousel-item-content-description {
	padding: 10px;
}

.panel-body-content .widget-chat-carousel-item-button.widget-chat-reply-button
	{
	width: 100%;
	color: #000;
	background: white;
	font-family: "Source Sans Pro", sans-serif !important;
	font-weight: 700;
	font-size: 16px;
	box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.4);
	border: 0;
	text-align: center;
	display: block;
	margin: 10px 0;
	padding: 10px 10px;
	cursor: pointer;
}

.panel-body-content .widget-chat-carousel-item-button.widget-chat-reply-button
	{
	background-color: #447BA8;
	color: #FFFFFF;
}

.panel-body-content .widget-chat-carousel-item-button.widget-chat-reply-button:hover
	{
	background: #fff;
	color: #000;
	text-decoration: none;
}

@media all and (max-width:767px) {
	.reciverchat-pane, .senderchat-pane {
		font-size: 14px;
		line-height: 20px;
	}
	.panel-body-content .widget-chat-text-message-item.widget-chat-message-item-server.widget-chat-message-item-server-center
		{
		max-width: 84%;
	}
	.chat_header h6 {
		font-size: 14px;
	}
	.panel-body-content .widget-chat-buttons {
		width: 70%;
	}
	.panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content .widget-chat-list-item-content-description
		{
		width: 100%;
	}
	.panel-body-content .content-box-sub-h {
		font-size: 14px;
	}
	.chat_box {
		position: static;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.pull-right2 {
		width: 100% !important;
	}
	.reciver_chat {
		width: 78%;
	}
	.sender_chat {
		width: 77%;
	}
}

@media all and (max-width:550px) {
	.chat_form input[type="text"] {
		width: 99%;
	}
}

@media all and (max-width:470px) {
	.nav-tabs>li {
		font-size: 11px;
	}
	.panel-body-content .nav>li>a {
		padding: 4px 5px;
	}
	.panel-body-content .widget-chat-buttons .widget-chat-button-item-question,
		.panel-body-content .widget-chat-buttons .widget-chat-button-item {
		font-size: 14px;
	}
	.chat_form input[type="text"] {
		background: url(../images/dropdown.png) no-repeat center right 10px #fff;
		line-height: 1.7;
		width: 99%;
		font-size: 13px;
	}
	.chat_box {
		right: 20px;
	}
	.chat_header p {
		margin: 20px 10px 0px 10px;
	}
}

@media all and (max-width:400px) {
	.chat_form input[type="text"] {
		width: 99%;
		padding-left: 20px;
	}
	.chat_header p {
		margin: 20px 0px 0px 0px;
	}
	.reciver_chat {
		width: 77%;
	}
	.sender_chat {
		width: 76%;
	}
}

@media all and (max-width:359px) {
	.chat_header h5 {
		font-size: 16px;
		margin: -21px 0 3px 22px;
	}
	.chat_header h6, .panel-body-content .widget-chat-buttons .widget-chat-button-item-question,
		.panel-body-content .widget-chat-buttons .widget-chat-button-item {
		font-size: 12px;
	}
	.reciverchat-pane {
		padding: 12px;
	}
	.reciverchat-pane, .senderchat-pane {
		font-size: 12px;
		line-height: 18px;
	}
	.panel-body-content h4, .panel-body-content .h4, .panel-body-content .widget-chat-list .widget-chat-list-item .widget-chat-list-item-content .widget-chat-list-item-content-description .widget-chat-list-item-content-description-button
		{
		font-size: 14px;
	}
	body {
		font-size: 12px;
	}
	.panel-body-content .widget-chat-text-message-item.widget-chat-message-item-server.widget-chat-message-item-server-center
		{
		font-size: 14px;
	}
	.panel-body-content .owl-carousel.owl-drag .owl-item {
		width: 93px !important;
	}
	.inner_content {
		font-size: 12px;
		line-height: 16px;
	}
}
</style>

<div class="chat-launcher" id="chaticon" style="background: #447BA8;"
				onclick="fnviewchat()"></div>

			<!-- Popup: Shopping cart items -->
			<div class="modal fade popup-cart" id="chatbot" tabindex="-1"
				role="dialog" aria-hidden="true" style="padding-top: 150px;">
				<div class="modal-dialog"></div>

			</div>
			<!-- /Popup: Shopping cart items -->

			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/adminResource/css/owl.carousel.min.css">
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/adminResource/css/owl.theme.default.min.css">


			<script>
				function fnviewchat() {
					document.getElementById("chatouter").style.display = "";
					document.getElementById("chaticon").style.display = "none";

				}
				function fnhidechat() {

					document.getElementById("chatouter").style.display = "none";
					document.getElementById("chaticon").style.display = "";
				}
			</script>


			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/adminResource/css/owl.carousel.min.css">
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/adminResource/css/owl.theme.default.min.css">
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/adminResource/css/jquery.mCustomScrollbar.css" />
			<script
				src="<%=request.getContextPath()%>/adminResource/js/owl.carousel.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/adminResource/js/jquery.mCustomScrollbar.concat.min.js"></script>
			<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>

			<div class="chat_outer panel-body-content" id="chatouter"
				style="display: none">
				<div class="chat_box" style="z-index: 9999">
					<!-- <div class="get-start"><span>Get Started</span></div> -->
					<div class="chat_header" style="background: #000000;">
						<!-- <img src="images/chat-logo.png"  /> -->
						<div class="pannel_setting">
							<a class="minimize" href="#" onclick="fnhidechat()"><img
								src="adminResources/images/minimize.png" /></a>
							<!-- <a class="cross" href="#"><img src="userResources/images/cross.png"  /></a>  -->
						</div>
						<h3
							style="font-family: monospace; font-style: italic; font-weight: lighter; color: #ffffff">
							Chat Bot</h3>
						<div class="user-position online">Online</div>
						<!-- <h6 style="font-family:inherit; font-style:italic;   color: #eee">We love to deliver you useful information 365 x 7 x 24 - Every moments!</h6> -->
						<h3 class="content-box-sub-h"></h3>
					</div>



					<div class="chat_room light">
						<div>

							<div id="chatcarousel">
								<div class="crousel_area">
									<div class="padding-crousel">
										<div class="item itmename"
											style="background-color: #25557c; font-weight: lighter;">
											<div>Hello , <b><%=BaseMethods.getCurrentUser()%></b></div>
										</div>

										<div class="owl-carousel">
										</div>
										</div>
								</div>
							</div>

						</div>


					</div>

					<div class="chat_form" style="background-color: #000000">
						<form>

							<!-- <span class="record"><a id="record"
						href="javascript:void(0)" ></a></span> 
					 -->
							<span> <input type="text" id="final_span"
								spellcheck="true" maxlength="500" name="noidung"
								placeholder="Send a message" autocomplete="off"
								style="font-weight: bold; color: black; font-style: italic"
								onkeypress="return runScript(event)">
							</span>
						</form>
					</div>
				</div>
				<script>
					$(document)
							.ready(
									function() {
										$(".owl-carousel")
												.owlCarousel(
														{
															nav : true,
															stagePadding : 30,
															margin : 10,
															navText : [
																	"<img src='userResources/images/previuos.png'>",
																	"<img src='userResources/images/next.png'>" ],
															responsive : {
																// breakpoint from 0 up
																0 : {
																	items : 2,
																},
																// breakpoint from 480 up
																480 : {
																	items : 3,
																},
																// breakpoint from 768 up
																768 : {
																	items : 2,
																}
															}
														});
										$(".record a").click(
												function() {
													$(".record a").toggleClass(
															"active");
												});
										$("input.submit_btn").click(
												function() {
													$("input.submit_btn")
															.toggleClass(
																	"active");
												});
										$(".mute a").click(function() {
											$(".mute a").toggleClass("active");
										});
									});
					$(".get-start span")
							.click(
									function() {
										$(".get-start").fadeOut();

										document.getElementById("final_span").value = "welcome";
										send();
									});

					(function($) {
						$(window).on("load", function() {
							$(".chat_room").mCustomScrollbar({
								theme : "minimal"
							});
						});
					})(jQuery);
				</script>

				<script>
					var incrementerSender = 0;
					var context = "";
					var carousel;
					var replies;
					var img;

					function runScript(e) {
						if (event.which == 13) {
							event.preventDefault();
							var tb = document.getElementById("final_span");
							//alert(tb.value);
							fnchattext();
							return false;
						}
					}

					function fnchattext() {
						var input = $("#final_span").val();
						if (input == null || input == 'null' || input == '') {
							//alert("Value........");
						} else {
							//console.log("incrementerSender" + incrementerSender);
							$(
									'<div class="sender_box_outer" id="divtest'+incrementerSender+'"><div class="sender_box"><div class="sender_logo"><img src="<%=request.getContextPath()%>/adminResource/images/sender-logo.png"  /></div><div class="sender_chat"><div class="senderchat-pane first">'
											+ input
											+ '<br /></div></div></div></div>')
									.appendTo('#chatcarousel');
							$('div.sender_box_outer').slideDown("slow");
							//console.log($("#chatcarousel").html());
							$("#mcs_container").mCustomScrollbar("scrollTo",
									'#divtest' + incrementerSender + '');
							incrementerSender++;
							send(incrementerSender);
						}
					}

					/* var accessToken = '39d979259b894dd586b1e48b550a4df2'; */
					/* var accessToken = '77f8c87da0bc4483884f52e090094a4c';   */

					//Toll_Free_Inquiry
					//var accessToken = '658cc0a0df2747b896a6009c91e04d9c';

					//Testing_Toll_Free
					var accessToken = 'e3a61b14fc9e48969556d9d411988120';

					/* var accessToken = '02de65b607b04e2594ceaac7f66a8e56';  */
					var passVar = 1;
					/* var accessToken = '129f9765ce2e4d42aafe01d17e4efa0d'; */
					var baseUrl = "https://api.api.ai/v1/query?v=20150910";
					var messageSorry = "I'm sorry, I don't have the answer to that yet.";
					var incrementer = 0;
					var message;
					var onlyButtons = 0;
					var userId = 1;

					//api.ai call ...
					function send() {
						var input = $("#final_span").val().toLowerCase();
						if (input == '' || input == '' || input == '') {

							var welcomeMessage = "We thank you for making an inquiry  with GRUH Finance Limited for a loan.<br>Kindly respond to the questionnaire below?";

							$(
									'<div class="reciver_box_outer" id="receiver'+incrementer+'"><div class="reciver_box"><div class="reciver_logo"><img src="<%=request.getContextPath()%>/adminResource/images/owner-logo.png"  /></div><div class="reciver_chat"><div class="reciverchat-pane first">'
											+ welcomeMessage
											+ '</div></div></div></div>')
									.appendTo('#chatcarousel');
							incrementer++;
							$("#mcs_container").mCustomScrollbar("scrollTo",
									'#receiver' + incrementer + '');
							console.log($("#chatcarousel").html());

							

						}
						$("#final_span").val("");
						//alert(input);
						$.ajax({
							type : "POST",
							url : baseUrl + "query",
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							headers : {
								"Authorization" : "Bearer " + accessToken
							},
							data : JSON.stringify({
								query : input,
								lang : "en",
								sessionId : ${sessionScope.loginId}
							}),
							success : function(data) {
								console.log("data");
								console.log(data);
								prepareResponse(data);
							}
						});
					}

					//generate the response ...
					function prepareResponse(val) {

						var messages = val.result.fulfillment.messages;
						if (val.result.contexts != null
								&& val.result.contexts.length > 0) {
							context = val.result.contexts[val.result.contexts.length - 1];
							console
									.log("========================================");
							console.log(context);
							console
									.log("========================================");

						}
						for (var i = 0; i < messages.length; i++) {
							var message = messages[i];
							//console.log(message);
							switch (message.type) {

							//text message .......
							case 0:
								/* alert("hi"); */

								message = message.speech;
								console.log("message", message);

								$(
										'<div class="reciver_box_outer" id="receiver'+incrementer+'"><div class="reciver_box"><div class="reciver_logo"><img src="<%=request.getContextPath()%>/adminResource/images/owner-logo.png"  /></div><div class="reciver_chat"><div class="reciverchat-pane first">'
												+ message
												+ '</div></div></div></div>')
										.appendTo('#chatcarousel');
								$("#mcs_container").mCustomScrollbar(
										"scrollTo",
										'#receiver' + incrementer + '');
								incrementer++;

								break;

							//cards ..............    
							case 1:
								//console.log("message == ",message);
								carousel = [ message ];
								//console.log("carousel == ",carousel);
								for (i++; i < messages.length; i++) {
									//console.log("carousel message.........");
									if (messages[i].type == 1) {
										carousel.push(messages[i]);
									} else {
										i--;
										break;
									}
								}
								var fullDiv;

								for (var i = 0; i < carousel.length; i++) {
									var button;
									if (i == 0) {

										//if buttons are present in the carosusel.....

										if (carousel[0].buttons.length != 0) {
											for (var j = 0; j < carousel[0].buttons.length; j++) {
												if (j == 0) {
													var text = carousel[0].buttons[j].postback;
													if (text.indexOf("http") > -1) {
														button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button"  target="_blank">'
																+ carousel[0].buttons[j].text
																+ '</a>';
													} else {
														button = '<a href="#" class="widget-chat-carousel-item-button widget-chat-reply-button" id="'
																+ carousel[0].buttons[j].text
																+ '" onclick = "fn(this.id);" value="'
																+ carousel[i].buttons[j].postback
																+ '">'
																+ carousel[0].buttons[j].text
																+ '</a>';
													}

												} else {
													var text = carousel[i].buttons[j].postback;
													if (text.indexOf("http") > -1) {
														button = button
																+ '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" target="_blank">'
																+ carousel[i].buttons[j].text
																+ '</a>';
													} else {
														button = button
																+ '<a href="#" id="'
																+ carousel[i].buttons[j].text
																+ '" class="widget-chat-carousel-item-button widget-chat-reply-button" '
																+ carousel[0].buttons[j].text
																+ ' onclick = "fn(this.id);" value="'
																+ carousel[i].buttons[j].postback
																+ '">'
																+ carousel[i].buttons[j].text
																+ '</a>';
													}

												}
											}

											//check if image is present or not ...
											if ("imageUrl" in carousel[i]) {

												//console.log("image is present......");
												fullDiv = '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
														+ carousel[i].title
														+ '</h4> </div> </div>'
														+ button
														+ '</div> </div>';
											} else {
												onlyButtons = 1;
												//console.log("image is not present..." + onlyButtons)
												fullDiv = '<div class="widget-chat-button-item-question"> <div class="widget-chat-button-item-question-content">'
														+ carousel[i].title
														+ '</div> </div>'
														+ button + '';
											}

										}

										// button is not present in carosuel....
										else
											fullDiv = '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
													+ carousel[i].title
													+ '</h4> </div> </div></div> </div>';

									} else {

										// morethan one buttons are present in carousel ...
										if (carousel[i].buttons.length != 0) {
											for (var j = 0; j < carousel[i].buttons.length; j++) {
												if (j == 0) {
													var text = carousel[i].buttons[j].postback;
													if (text.indexOf("http") > -1) {
														button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" target="_blank">'
																+ carousel[i].buttons[j].text
																+ '</a>';
													} else {
														button = '<a href="#" id='
																+ carousel[i].buttons[j].text
																+ ' class="widget-chat-carousel-item-button widget-chat-reply-button" onclick = "fn(this.id);" value='
																+ carousel[i].buttons[j].postback
																+ '>'
																+ carousel[i].buttons[j].text
																+ '</a>';
													}

												} else {
													var text = carousel[i].buttons[j].postback;
													if (text.indexOf("http") > -1) {
														button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" id='+carousel[i].buttons[j].text+' target="_blank">'
																+ carousel[i].buttons[j].text
																+ '</a>';
													} else {
														button = '<a href="#" class="widget-chat-carousel-item-button widget-chat-reply-button" id='
																+ carousel[i].buttons[j].text
																+ ' onclick = "fn(this.id);" value='
																+ carousel[i].buttons[j].postback
																+ '>'
																+ carousel[i].buttons[j].text
																+ '</a>';
													}

												}
											}

											fullDiv = fullDiv
													+ '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
													+ carousel[i].title
													+ '</h4> </div> </div>'
													+ button + '</div> </div>';

										}
										//button is not present in carousel ...	
										else
											fullDiv = fullDiv
													+ '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
													+ carousel[i].title
													+ '</h4> </div> </div></div> </div>';

									}
								}

								//check if only buttons is present  than apply css of button not carousel ...
								if (onlyButtons == 1) {
									$(
											'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="widget-chat-buttons">'
													+ fullDiv
													+ '</div></div></div>')
											.appendTo('#carousel');
								}

								//apply css of carousel ...
								else {
									$(
											'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="owl-carousel">'
													+ fullDiv
													+ '</div> </div> </div>')
											.appendTo('#carousel');
								}

								$(".owl-carousel")
										.owlCarousel(
												{
													nav : true,
													stagePadding : 30,
													margin : 10,
													navText : [
															"<img src='images/previuos.png'>",
															"<img src='images/next.png'>" ],
													responsive : {
														// breakpoint from 0 up
														0 : {
															items : 2,
														},
														// breakpoint from 480 up
														480 : {
															items : 3,
														},
														// breakpoint from 768 up
														768 : {
															items : 2,
														}
													}
												});

								$("#mcs_container").mCustomScrollbar(
										"scrollTo",
										'#carousel' + incrementer + '');
								incrementer++;

								break;

							// Quick  replay    
							case 2:
								replies = message.replies;

								var fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button">I like it!</button> </div>';

								for (var i = 0; i < replies.length; i++) {
									if (i == 0) {

										fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value='
												+ replies[i]
												+ ' id='
												+ replies[i]
												+ ' onclick = "myFunction(this.id);">'
												+ replies[i]
												+ '</button> </div>';
									} else
										fullDiv = fullDiv
												+ '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value='
												+ replies[i]
												+ ' id='
												+ replies[i]
												+ ' onclick = "myFunction(this.id);">'
												+ replies[i]
												+ '</button> </div>';
								}

								$(
										'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="owl-carousel">'
												+ fullDiv
												+ '</div> </div> </div>')
										.appendTo('#carousel');
								//carousel effect style and scroll images
								$(".owl-carousel")
										.owlCarousel(
												{
													nav : true,
													stagePadding : 30,
													margin : 10,
													navText : [
															"<img src='images/previuos.png'>",
															"<img src='images/next.png'>" ],
													responsive : {
														0 : {
															items : 2,
														},
														480 : {
															items : 3,
														},
														768 : {
															items : 2,
														}
													}
												});

								$("#mcs_container").mCustomScrollbar(
										"scrollTo",
										'#carousel' + incrementer + '');
								incrementer++;

								break;

							//only image replay
							case 3:

								if (message.imageUrl) {
									//console.log("image message.........");
									img = message.imageUrl;
									// console.log(img);
								}

								break;

							//custom payload ...
							case 4:
								if (message.payload && message.payload.facebook) {

									//console.log(message.payload.facebook.attachment.payload);
									if ('elements' in message.payload.facebook.attachment.payload) {
										var elements = message.payload.facebook.attachment.payload.elements;
										var fullDiv;
										for (var i = 0; i < elements.length; i++) {
											var element = elements[i];
											var title = element.title;
											var image_url = element.image_url;
											var subtitle = element.subtitle;
											var buttons = element.buttons;
											//console.log(element);
											//console.log(title);
											//console.log(image_url);
											//console.log(subtitle);
											//console.log(buttons.length);

											var button_value = buttons[0].title;

											if (i == 0) {
												fullDiv = '<div class="widget-chat-list-item"> <div class="widget-chat-list-item-content"> <div class="widget-chat-list-item-content-description"> <h4 class="widget-chat-list-item-content-description-title">'
														+ title
														+ '</h4> <div class="widget-chat-list-item-content-description-subtitle">'
														+ subtitle
														+ '</div><button class="widget-chat-list-item-content-description-button widget-chat-reply-button">'
														+ button_value
														+ '</button></div> <img class="widget-chat-list-item-content-image" src="'+image_url+'"> </div> </div>'
											}

											else {
												fullDiv = fullDiv
														+ '<div class="widget-chat-list-item"> <div class="widget-chat-list-item-content"> <div class="widget-chat-list-item-content-description"> <h4 class="widget-chat-list-item-content-description-title">'
														+ title
														+ '</h4> <div class="widget-chat-list-item-content-description-subtitle">'
														+ subtitle
														+ '</div><button class="widget-chat-list-item-content-description-button widget-chat-reply-button">'
														+ button_value
														+ '</button></div> <img class="widget-chat-list-item-content-image" src="'+image_url+'"> </div> </div>'
											}

										}
										$(
												'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="widget-chat-list">'
														+ fullDiv
														+ '</div></div> </div>')
												.appendTo('#carousel');

										//apply scrolling images and style ...
										$(".owl-carousel")
												.owlCarousel(
														{
															nav : true,
															stagePadding : 30,
															margin : 10,
															navText : [
																	"<img src='images/previuos.png'>",
																	"<img src='images/next.png'>" ],
															responsive : {
																0 : {
																	items : 2,
																},
																480 : {
																	items : 3,
																},
																768 : {
																	items : 2,
																}
															}
														});

										$("#mcs_container").mCustomScrollbar(
												"scrollTo",
												'#carousel' + incrementer + '');
									} else if ('quick_replies' in message.payload.facebook.attachment.payload) {
										var replies = message.payload.facebook.attachment.payload.quick_replies;
										//console.log("replies  == "+replies);
										var fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button">I like it!</button> </div>';

										for (var i = 0; i < replies.length; i++) {
											//console.log(replies[i].payload);
											if (i == 0) {

												fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value="'
														+ replies[i].payload
														+ '" id="'
														+ replies[i].payload
														+ '" onclick = "myFunction(this.id);">'
														+ replies[i].title
														+ '</button> </div>';
											} else
												fullDiv = fullDiv
														+ '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value="'
														+ replies[i].payload
														+ '" id="'
														+ replies[i].payload
														+ '" onclick = "myFunction(this.id);">'
														+ replies[i].title
														+ '</button> </div>';
										}

										$(
												'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="owl-carousel">'
														+ fullDiv
														+ '</div> </div> </div>')
												.appendTo('#carousel');
										//carousel effect style and scroll images
										$(".owl-carousel")
												.owlCarousel(
														{
															nav : true,
															stagePadding : 30,
															margin : 10,
															navText : [
																	"<img src='images/previuos.png'>",
																	"<img src='images/next.png'>" ],
															responsive : {
																0 : {
																	items : 2,
																},
																480 : {
																	items : 3,
																},
																768 : {
																	items : 2,
																}
															}
														});

										$("#mcs_container").mCustomScrollbar(
												"scrollTo",
												'#carousel' + incrementer + '');
									} else {
										var carousel = message.payload.facebook.attachment.payload.card;
										//console.log("message == ",message);
										//var carousel = [message];
										console.log("carousel == ", carousel);
										//console.log("carousel == ",carousel);
										for (var i; i < messages.length; i++) {
											// console.log("carousel message.........");
											if (messages[i].type == 1) {
												carousel.push(messages[i]);
											} else {
												i--;
												break;
											}
										}
										var fullDiv;

										for (var i = 0; i < carousel.length; i++) {
											var button;
											if (i == 0) {

												//if buttons are present in the carosusel.....

												if (carousel[0].buttons.length != 0) {
													for (var j = 0; j < carousel[0].buttons.length; j++) {
														if (j == 0) {
															var text = carousel[0].buttons[j].postback;
															if (text
																	.indexOf("http") > -1) {
																button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button"  target="_blank">'
																		+ carousel[0].buttons[j].text
																		+ '</a>';
															} else {
																button = '<a href="#" class="widget-chat-carousel-item-button widget-chat-reply-button" id="'
																		+ carousel[0].buttons[j].text
																		+ '" onclick = "fn(this.id);" value="'
																		+ carousel[i].buttons[j].postback
																		+ '">'
																		+ carousel[0].buttons[j].text
																		+ '</a>';
															}

														} else {
															var text = carousel[i].buttons[j].postback;
															if (text
																	.indexOf("http") > -1) {
																button = button
																		+ '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" target="_blank">'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															} else {
																button = button
																		+ '<a href="#" id="'
																		+ carousel[i].buttons[j].text
																		+ '" class="widget-chat-carousel-item-button widget-chat-reply-button" '
																		+ carousel[0].buttons[j].text
																		+ ' onclick = "fn(this.id);" value="'
																		+ carousel[i].buttons[j].postback
																		+ '">'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															}

														}
													}

													//check if image is present or not ...
													if ("imageUrl" in carousel[i]) {

														//console.log("image is present......");
														fullDiv = '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
																+ carousel[i].title
																+ '</h4> </div> </div>'
																+ button
																+ '</div> </div>';
													} else {
														onlyButtons = 1;
														//console.log("image is not present..." + onlyButtons)
														fullDiv = '<div class="widget-chat-button-item-question"> <div class="widget-chat-button-item-question-content">'
																+ carousel[i].title
																+ '</div> </div>'
																+ button + '';
													}

												}

												// button is not present in carosuel....
												else
													fullDiv = '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
															+ carousel[i].title
															+ '</h4> </div> </div></div> </div>';

											} else {

												// morethan one buttons are present in carousel ...
												if (carousel[i].buttons.length != 0) {
													for (var j = 0; j < carousel[i].buttons.length; j++) {
														if (j == 0) {
															var text = carousel[i].buttons[j].postback;
															if (text
																	.indexOf("http") > -1) {
																button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" target="_blank">'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															} else {
																button = '<a href="#" id='
																		+ carousel[i].buttons[j].text
																		+ ' class="widget-chat-carousel-item-button widget-chat-reply-button" onclick = "fn(this.id);" value='
																		+ carousel[i].buttons[j].postback
																		+ '>'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															}

														} else {
															var text = carousel[i].buttons[j].postback;
															if (text
																	.indexOf("http") > -1) {
																button = '<a href='+text+' class="widget-chat-carousel-item-button widget-chat-reply-button" id='+carousel[i].buttons[j].text+' target="_blank">'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															} else {
																button = '<a href="#" class="widget-chat-carousel-item-button widget-chat-reply-button" id='
																		+ carousel[i].buttons[j].text
																		+ ' onclick = "fn(this.id);" value='
																		+ carousel[i].buttons[j].postback
																		+ '>'
																		+ carousel[i].buttons[j].text
																		+ '</a>';
															}

														}
													}

													fullDiv = fullDiv
															+ '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
															+ carousel[i].title
															+ '</h4> </div> </div>'
															+ button
															+ '</div> </div>';

												}
												//button is not present in carousel ...	
												else
													fullDiv = fullDiv
															+ '<div> <div class="widget-chat-carousel-item"> <div class="widget-chat-carousel-item-content"> <div class="widget-chat-carousel-item-content-image" style="background-image: url(" petersfancybrownhats.com/company_image.png");"><img src="'+carousel[i].imageUrl+'" alt="" /></div> <div class="widget-chat-carousel-item-content-description"> <h4 class="widget-chat-carousel-item-content-description-title">'
															+ carousel[i].title
															+ '</h4> </div> </div></div> </div>';

											}
										}

										//check if only buttons is present  than apply css of button not carousel ...
										if (onlyButtons == 1) {
											$(
													'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="widget-chat-buttons">'
															+ fullDiv
															+ '</div></div></div>')
													.appendTo('#carousel');
										}

										//apply css of carousel ...
										else {
											$(
													'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="owl-carousel">'
															+ fullDiv
															+ '</div> </div> </div>')
													.appendTo('#carousel');
										}

										$(".owl-carousel")
												.owlCarousel(
														{
															nav : true,
															stagePadding : 30,
															margin : 10,
															navText : [
																	"<img src='images/previuos.png'>",
																	"<img src='images/next.png'>" ],
															responsive : {
																// breakpoint from 0 up
																0 : {
																	items : 2,
																},
																// breakpoint from 480 up
																480 : {
																	items : 3,
																},
																// breakpoint from 768 up
																768 : {
																	items : 2,
																}
															}
														});

										$("#mcs_container").mCustomScrollbar(
												"scrollTo",
												'#carousel' + incrementer + '');
									}
									incrementer++;
								}
								break;

							default:
								break;

							}
						}

					}

					//take the value of the button tag ...
					function myFunction(id) {
						//console.log(document.getElementById(id).value);
						document.getElementById("final_span").value = document
								.getElementById(id).value;
						fnchattext();
					}

					function fn(a) {
						//take tha value of the anchor tag ...
						//alert(d.getAttribute( 'value' ));
						var d = document.getElementById(a);
						document.getElementById("final_span").value = d.text;
						fnchattext();
					}

					function genereateDefaultOptionMessage(welcomeMessage,
							tempReplies) {
						console.log(" ===  genereateDefaultOptionMessage  == ");
						$(
								'<div class="reciver_box_outer" id="receiver'+incrementer+'"><div class="reciver_box"><div class="reciver_logo"><img src="userResources/images/owner-logo.png"  /></div><div class="reciver_chat"><div class="reciverchat-pane first">'
										+ welcomeMessage
										+ '</div></div></div></div>').appendTo(
								'#carousel');
						alert("2369" + welcomeMessage);
						incrementer++;

						var message = "A) Ready made house purchase from developer <br>";
						message = message
								+ "B) Purchase of old house in resale <br>";
						message = message
								+ "C) Purchase of plot and construction thereon <br>";
						message = message
								+ "D) Loan Against Existing property <br>";
						message = message
								+ "E) Loan against Commercial property <br>";
						message = message
								+ "F) Loan for Repair / Renovation <br>";
						message = message + "G) Plot loan <br>";
						message = message + "H) Personal loan <br>";
						message = message + "I) Loan against receivables <br>";

						$(
								'<div class="reciver_box_outer" id="receiver'+incrementer+'"><div class="reciver_box"><div class="reciver_logo"><img src="userResources/images/owner-logo.png"  /></div><div class="reciver_chat"><div class="reciverchat-pane first">'
										+ message + '</div></div></div></div>')
								.appendTo('#carousel');
						$("#mcs_container").mCustomScrollbar("scrollTo",
								'#receiver' + incrementer + '');
						alert("2384" + welcomeMessage);

						replies = tempReplies;

						var fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button">I like it!</button> </div>';

						for (var i = 0; i < replies.length; i++) {
							if (i == 0) {

								fullDiv = '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value='
										+ replies[i]
										+ ' id='
										+ replies[i]
										+ ' onclick = "myFunction(this.id);">'
										+ replies[i] + '</button> </div>';
							} else
								fullDiv = fullDiv
										+ '<div> <button class="widget-chat-quick-reply-item widget-chat-reply-button" value='
										+ replies[i] + ' id=' + replies[i]
										+ ' onclick = "myFunction(this.id);">'
										+ replies[i] + '</button> </div>';
						}

						$(
								'<div class="crousel_area" id="carousel'+incrementer+'"> <div class="padding-crousel"><div class="owl-carousel">'
										+ fullDiv + '</div> </div> </div>')
								.appendTo('#carousel');
						//carousel effect style and scroll images
						$(".owl-carousel").owlCarousel(
								{
									nav : true,
									stagePadding : 30,
									margin : 10,
									navText : [
											"<img src='images/previuos.png'>",
											"<img src='images/next.png'>" ],
									responsive : {
										0 : {
											items : 2,
										},
										480 : {
											items : 3,
										},
										768 : {
											items : 2,
										}
									}
								});

						$("#mcs_container").mCustomScrollbar("scrollTo",
								'#carousel' + incrementer + '');
						incrementer++;
					}
				</script>
			</div>
			<script>
				$(document)
						.ready(
								function() {

									$('#itemslider').carousel({
										interval : 3000
									});

									$('.carousel-showmanymoveone .item')
											.each(
													function() {
														var itemToClone = $(this);

														for (var i = 1; i < 6; i++) {
															itemToClone = itemToClone
																	.next();

															if (!itemToClone.length) {
																itemToClone = $(
																		this)
																		.siblings(
																				':first');
															}

															itemToClone
																	.children(
																			':first-child')
																	.clone()
																	.addClass(
																			"cloneditem-"
																					+ (i))
																	.appendTo(
																			$(this));
														}
													});
								});
			</script>
			
			
			
			
<script>
var xvalue= document.getElementsByName("xvalue");
var xdata = [];
var yvalue= document.getElementsByName("yvalue");
var ydata = [];
for(var i=0;i<xvalue.length;i++)
{
	xdata.push(xvalue[i].value);
	ydata.push(parseFloat(yvalue[i].value));
}
Highcharts.chart({
    chart: {
	renderTo:"container",

        type: 'column'
    },
    title: {
        text: 'Sales report of products'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        categories: xdata,
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Total Units'
        }
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'Product Name',
        data: ydata

    }]
});
</script>