/** Windows IE32 * */
var PGEdit_IE32_CLASSID="B39793DB-C5FF-4114-8C0C-F23240F303D8";
var PGEdit_IE32_CAB="LLSecurityPayEdit.cab#version=1,0,0,1";//PassGuardX.cab#version=1,0,0,2";
var PGEdit_IE32_EXE="LLSecurityPayEdit.exe";
var PGEdit_IE32_VERSION="1.0.0.1";
/** Windows IE64 * */
var PGEdit_IE64_CLASSID="7F34596D-56B8-484A-AAB8-B16CF58B6726";
var PGEdit_IE64_CAB="LLSecurityPayEditX64.cab#version=1,0,0,1";//PassGuardX64.cab#version=1,0,0,2";
var PGEdit_IE64_EXE="LLSecurityPayEditX64.exe";
var PGEditt_IE64_VERSION="1.0.0.8";
/** Windows 非IE * */
var PGEdit_FF="LLSecurityPayEditFF.exe";
var PGEdit_FF_VERSION="1.0.0.1";
/** Edge/Chrome42+ * */
var PGEdit_Edge="LLSecurityPayEditEdge.exe";
var PGEdit_Edge_Mac="LLSecurityPayEditEdge.pkg";
var PGEdit_Edge_VERSION="1.0.0.3";
/** Linux * */
var PGEdit_Linux32="";
var PGEdit_Linux64="";
var PGEdit_Linux_VERSION="";
/** Mac * */
var PGEdit_MacOs="LLSecurityPayEdit.pkg";
var PGEdit_MacOs_VERSION="1.0.0.1";
var PGEdit_MacOs_Safari="LLSecurityPayEdit.pkg";
var PGEdit_MacOs_Safari_VERSION="1.0.0.1";

/** Edge/Chrome42+环境下用到的一些变量 * */
//控件服务地址
var urls = "https://windows10.microdone.cn:5271";
var port=5271;
//检查控件是否安装json串
var CIJSON = {"interfacetype":0,"data":{"switch":3}};
//实例化控件json串
var ICJSON = {"interfacetype":0,"data":{"switch":2}};
//初始化控件参数json串
var INCJSON = {"interfacetype":1,"data":{}};
//开启控件保护json串
var OPJSON = {"interfacetype":0,"data":{"switch":0}};
//心跳监测json串
var XTJSON = {"interfacetype":0,"data":{"switch":5}};
//关闭控件保护json串
var CPJSON = {"interfacetype":0,"data":{"switch":1}};
//获取值类json串
var OUTJSON = {"interfacetype":2,"data":{}};
//清空密码json串
var CLPJSON = {"interfacetype":0,"data":{"switch":4}};
//心跳监听变量、集合
var interv;
var onceInterv={};
var iterArray=[];
//控件返回值集合
var outs = {};
//控制是否能输入
var inFlag = {};
//是否初始化成功
var isInit = {};
/**license**/
var license = "Y0ZwYlhXTWtncjdxM1U4aWRSZW5ReWtDMWNGamk1WldYcFV2OEp6YU00UG84aENTSEtETmx4TVJLd2JGbU9rMTdESWZSL3FXMTJvTmhqMVRVdDlna0lJMkJmWnNIcm80Q2F1SkdRbzBUTjUweUtBdGJKcDgrejJnSVlLQXNnb0FQWkY1aDJqR0wwNVJaSkEwR3pqS3VMR1NUbzZwU1RZRkErb2JtSkdqb3BzPXsiaWQiOjAsInR5cGUiOiJ0ZXN0IiwicGxhdGZvcm0iOjQsIm5vdGJlZm9yZSI6IjIwMjIxMjA4Iiwibm90YWZ0ZXIiOiIyMDIzMDYwOCJ9";
var licenseMac = "ZXR0MGRpeU5KZ3RRUWtpOHpTNi9ZdUg0Ni9ZWGVPZC9KZks4aEx0MC9lbWszZEhxSGVGY25SK3JTTG5aN21WdHBMSUJjS1FWTFFXNTIzUDdkcWx5cVFWVXF6UmxYUStnaFVXRWMrenZSUitqV0lEN0Y1WW11UXl5cklBeVdQUytpRXd3Ulczb1IvaVo5MVRySzRUa3RYbXlZc0RWOHZQVHA0K0JDSlJxYzRBPXsiaWQiOjAsInR5cGUiOiJ0ZXN0IiwicGxhdGZvcm0iOjgsIm5vdGJlZm9yZSI6IjIwMjIxMjA4Iiwibm90YWZ0ZXIiOiIyMDIzMDYwOCJ9";
var PGEdit_Update="0";//非IE控件是否强制升级 1强制升级,0不强制升级


if(navigator.userAgent.indexOf("MSIE")<0){
	   navigator.plugins.refresh();
}
(function(jQuery) {
	jQuery.pge = function (options) {
		this.settings = jQuery.extend(true, {}, jQuery.pge.defaults, options);
		
			
			this.init();
		
		
	};
	jQuery.extend(jQuery.pge, {
		defaults: {
			pgePath: "./ocx/",
			pgeId: "",
			pgeEdittype: 0,
			pgeEreg1: "",
			pgeEreg2: "",
			pgeMaxlength: 12,
			pgeTabindex: 2,
			pgeClass: "ocx_style",
			pgeInstallClass: "ocx_style",
			passLoginStyle:"passLoginStyle",
			pgeOnkeydown:"",
			pgeFontName:"",
			pgeFontSize:"",
			tabCallback:"",
			pgeBackColor:"",
			pgeForeColor:"",
			pgeUrls:"https://windows10.microdone.cn",
			pgePort:5266,
			pgeWindowID:"password"+new Date().getTime()
		
		},
		prototype: {
			init: function() {				
			//初始化控件返回值集合
				outs[this.settings.pgeWindowID] = {
					"length" : 0,
					"version" : 0,
					"mac" : "",
					"hard" : "",
					"cpu" : "",
					"aes" : "",
					"valid" : 1,
					"hash" : "",
					"rsa" : "",
					"pin" : "",
					"sign":"",
					"charNum":"",
					"hardList":""
				};
			    
			    this.pgeDownText="请点此安装控件";
			    this.osBrowser = this.checkOsBrowser();
			    this.pgeVersion = this.getVersion();			    			
			    this.isInstalled= this.checkInstall();
			},
			checkOsBrowser: function() {
				var userosbrowser;
				var regStr_chrome = /chrome\/[\d.]+/gi ;
				var regStr_firefox =  /firefox\/[\d.]+/gi ;
				var regStr_mac =  /Version\/[\d.]+/gi;
				if((navigator.platform =="Win32") || (navigator.platform =="Windows")){
					if(navigator.userAgent.indexOf("MSIE")>0 || navigator.userAgent.indexOf("msie")>0 || navigator.userAgent.indexOf("Trident")>0 || navigator.userAgent.indexOf("trident")>0){
						if(navigator.userAgent.indexOf("ARM")>0){
							userosbrowser=9; // win8 RAM Touch
							this.pgeditIEExe="";
						}else{
							userosbrowser=1;// windows32ie32
							this.pgeditIEClassid=PGEdit_IE32_CLASSID;
							this.pgeditIECab=PGEdit_IE32_CAB;
							this.pgeditIEExe=PGEdit_IE32_EXE;
						}
					}else if(navigator.userAgent.indexOf("Edge")>0){
						userosbrowser = 10;
						this.pgeditFFExe = PGEdit_Edge;
					}else if(navigator.userAgent.indexOf("Chrome")>0){
						var chromeVersion = navigator.userAgent.match(regStr_chrome).toString();
						chromeVersion = parseInt(chromeVersion.replace(/[^0-9.]/gi,""));
						if(chromeVersion >= 42){
							userosbrowser = 10;
							this.pgeditFFExe = PGEdit_Edge;
						}else{
							userosbrowser=2;
							this.pgeditFFExe = PGEdit_FF;
						}
					}else if(navigator.userAgent.indexOf("Firefox")>0){
						var firefoxVersion = navigator.userAgent.match(regStr_firefox).toString();
						firefoxVersion = parseInt(firefoxVersion.replace(/[^0-9.]/gi,""));
						if(firefoxVersion >= 51){
							userosbrowser = 10;
							this.pgeditFFExe = PGEdit_Edge;
						}else{
							userosbrowser=2;
							this.pgeditFFExe = PGEdit_FF;
						}
					}else{
						userosbrowser=2; // windowsff
						this.pgeditFFExe=PGEdit_FF;
					}
				}else if((navigator.platform=="Win64")){
					if((navigator.userAgent.indexOf("Windows NT 6.2")>0 || navigator.userAgent.indexOf("windows nt 6.2")>0) && navigator.userAgent.indexOf("Firefox") == -1){		
						userosbrowser=1;// windows32ie32
						this.pgeditIEClassid=PGEdit_IE32_CLASSID;
						this.pgeditIECab=PGEdit_IE32_CAB;
						this.pgeditIEExe=PGEdit_IE32_EXE;						
					}else if(navigator.userAgent.indexOf("MSIE")>0 || navigator.userAgent.indexOf("msie")>0 || navigator.userAgent.indexOf("Trident")>0 || navigator.userAgent.indexOf("trident")>0){
						userosbrowser=3;//windows64ie64
						this.pgeditIEClassid=PGEdit_IE64_CLASSID;
						this.pgeditIECab=PGEdit_IE64_CAB;
						this.pgeditIEExe=PGEdit_IE64_EXE;			
					}else if(navigator.userAgent.indexOf("Edge")>0 || navigator.userAgent.indexOf("Firefox")){
						userosbrowser = 10;
						this.pgeditFFExe = PGEdit_Edge;
					}else if(navigator.userAgent.indexOf("Chrome")>0){
						var chromeVersion = navigator.userAgent.match(regStr_chrome).toString();
						chromeVersion = parseInt(chromeVersion.replace(/[^0-9.]/gi,""));
						if(chromeVersion >= 42){
							userosbrowser = 10;
							this.pgeditFFExe = PGEdit_Edge;
						}else{
							userosbrowser = 2;
							this.pgeditFFExe = PGEdit_FF;
						}
					}else{
						userosbrowser=2;
						this.pgeditFFExe=PGEdit_FF;
					}
				}else if(navigator.userAgent.indexOf("Macintosh")>0){
					if(navigator.userAgent.indexOf("Safari")>0 && (navigator.userAgent.indexOf("Version/5.1")>0 || navigator.userAgent.indexOf("Version/5.2")>0 || navigator.userAgent.indexOf("Version/6")>0)){
						userosbrowser=8;//macos Safari 5.1 more
						this.pgeditFFExe=PGEdit_MacOs;
					}else if(navigator.userAgent.indexOf("Firefox")>0 || navigator.userAgent.indexOf("Chrome")>0){
						var chromeVersion = navigator.userAgent.match(regStr_chrome);
						var firefoxVersion = navigator.userAgent.match(regStr_firefox);
						if( chromeVersion != null){
							chromeVersion = chromeVersion.toString();
							chromeVersion = parseInt(chromeVersion.replace(/[^0-9.]/gi,""));
							if(chromeVersion >= 42){
								userosbrowser = 11;
								this.pgeditFFExe = PGEdit_Edge_Mac;
							}else{
								userosbrowser=6;
								this.pgeditFFExe = PGEdit_MacOs;		
							}
						}

						if( firefoxVersion != null){
							firefoxVersion = firefoxVersion.toString();
							firefoxVersion = parseInt(firefoxVersion.replace(/[^0-9.]/gi,""));
							if(firefoxVersion >= 50){
								userosbrowser = 11;
								this.pgeditFFExe = PGEdit_Edge_Mac;
							}else{
								userosbrowser=6;
								this.pgeditFFExe = PGEdit_MacOs;		
							}
						}
					}else if(navigator.userAgent.indexOf("Opera")>=0 && (navigator.userAgent.indexOf("Version/11.6")>0 || navigator.userAgent.indexOf("Version/11.7")>0)){
						userosbrowser=6;//macos
						this.pgeditFFExe=PGEdit_MacOs;						
					}else if(navigator.userAgent.indexOf("Safari")>=0){
						var safariVersion = navigator.userAgent.match(regStr_mac);
						// 补充 macos 下 safari 的问题
						if ( safariVersion != null) {
							safariVersion = safariVersion.toString();
							safariVersion = parseInt(safariVersion.replace(/[^0-9.]/gi,""));
						
							if(safariVersion >= 12){
								userosbrowser = 11;
								this.pgeditFFExe = PGEdit_Edge_Mac;
							}else{
								userosbrowser = 6; //macos
								this.pgeditFFExe = PGEdit_MacOs;  
							};
						} else {
							userosbrowser=6;//macos
							this.pgeditFFExe=PGEdit_MacOs;			
						}	
					}else{
						userosbrowser=0;//macos
						this.pgeditFFExe="";
					}
				}
				return userosbrowser;
			},
			getpgeHtml: function() {
				if (this.osBrowser==1 || this.osBrowser==3) {
					return '<span id="'+this.settings.pgeId+'_pge" class="'+this.settings.passLoginStyle+'"><OBJECT ID="' + this.settings.pgeId + '" CLASSID="CLSID:' + this.pgeditIEClassid + '" codebase="' 
					        +this.settings.pgePath+ this.pgeditIECab + '" onkeydown="if(13==event.keyCode || 27==event.keyCode)'+this.settings.pgeOnkeydown+';" onfocus="' + this.settings.pgeOnfocus + '" tabindex="'+this.settings.pgeTabindex+'" class="' + this.settings.pgeClass + '">' 
					        + '<param name="edittype" value="'+ this.settings.pgeEdittype + '"><param name="maxlength" value="' + this.settings.pgeMaxlength +'">' 
							+ '<param name="input2" value="'+ this.settings.pgeEreg1 + '"><param name="input3" value="'+ this.settings.pgeEreg2 + '"></OBJECT></span>'
							+ '<span id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="display:none;"><a href="'+this.settings.pgePath+this.pgeditIEExe+'">'+this.pgeDownText+'</a></span>';
				} else if (this.osBrowser==2) {
					var pgeOcx='<embed ID="' + this.settings.pgeId + '"  maxlength="'+this.settings.pgeMaxlength+'" input_2="'+this.settings.pgeEreg1+'" input_3="'+this.settings.pgeEreg2+'" edittype="'+this.settings.pgeEdittype+'" type="application/ll-security-pay-edit" tabindex="'+this.settings.pgeTabindex+'" class="' + this.settings.pgeClass + '" ';
					if(this.settings.pgeOnkeydown!=undefined && this.settings.pgeOnkeydown!="") pgeOcx+=' input_1013="'+this.settings.pgeOnkeydown+'"';
					if(this.settings.tabCallback!=undefined && this.settings.tabCallback!="") pgeOcx+=' input_1009="document.getElementById(\''+this.settings.tabCallback+'\').focus()"';
					if(this.settings.pgeFontName!=undefined && this.settings.pgeFontName!="") pgeOcx+=' FontName="'+this.settings.pgeFontName+'"';
					if(this.settings.pgeFontSize!=undefined && this.settings.pgeFontSize!="") pgeOcx+=' FontSize='+Number(this.settings.pgeFontSize)+'';					
					pgeOcx+=' >';
					return pgeOcx;
				} else if (this.osBrowser==6) {
					return '<embed ID="' + this.settings.pgeId + '" input2="'+ this.settings.pgeEreg1 + '"  input3="'+ this.settings.pgeEreg2 + '" input4="'+Number(this.settings.pgeMaxlength)+'" input0="'+Number(this.settings.pgeEdittype)+'" type="application/ll-security-pay-edit" version="'+PGEdit_MacOs_VERSION+'" tabindex="'+this.settings.pgeTabindex+'" class="' + this.settings.pgeClass + '">';
				} else if (this.osBrowser==8) {
					return '<embed ID="' + this.settings.pgeId + '" input2="'+ this.settings.pgeEreg1 + '" input3="'+ this.settings.pgeEreg2 + '" input4="'+Number(this.settings.pgeMaxlength)+'" input0="'+Number(this.settings.pgeEdittype)+'" type="application/ll-security-pay-edit" version="'+PGEdit_MacOs_Safari_VERSION+'" tabindex="'+this.settings.pgeTabindex+'" class="' + this.settings.pgeClass + '">';
				} else if (this.osBrowser == 10 || this.osBrowser == 11){
				
					  var obj = this;
						
						this.checkInstall(1,function(isInstalled){
							
							if(isInstalled){
								console.log("是否安装"+isInstalled);
								//获得input框id值
								var id = obj.settings.pgeId;
								//获得控件窗口id值
								var winId = obj.settings.pgeWindowID;

								if((obj.getConvertVersion(outs[winId].version)<obj.getConvertVersion(PGEdit_Edge_VERSION))&&PGEdit_Update=="1"){
									var winPath = obj.settings.pgePath+obj.pgeditFFExe;
									$(".winA").html("请点此升级控件");
									$(".winA").attr("href",winPath);
								}else{
									var fos = "";
									if(obj.osBrowser == 10){
										 fos = "this.type='password';";
									}
									$("#"+id+"_down").parent().html('<input placeholder="请输入密码" type="text" onfocus="'+fos+'pgeCtrl.openProt(\''+winId+'\',this.id);pgeCtrl.setCX(this);'+obj.settings.pgeOnfocus+'" onkeydown="pgeCtrl.setSX(event,\''+obj.settings.pgeOnkeydown+'\',this);" onclick = "pgeCtrl.setCX(this)" onblur = "pgeCtrl.closeProt(\''+winId+'\',this.id);'+obj.settings.pgeOnblur+'" id = "'+id+'" style="ime-mode:disabled" tabindex="2" class="' + obj.settings.pgeClass + '"/>');
									
								
								var o = document.getElementById(id);
								if(o != null){
									if(obj.osBrowser == 11){
										document.getElementById(id).type="text";
										
										o.onkeypress = function(e){
											var chrTyped, chrCode=0, evt=e?e:event;
											chrCode = evt.which;
											var x = String.fromCharCode(chrCode);
											var maxlength = parseInt(obj.settings.pgeMaxlength);
											
											if(chrCode>=32 && chrCode<=126){
												if(this.value.length > (maxlength-1)){
													return false;
												}
												//GetLevel();
												var reg1 = obj.settings.pgeEreg1.replace("*","");
												reg1 = new RegExp(reg1);
												if(reg1.test(x)){
													this.value+='*';
												}
												return false;
											}else{
												return true;
											}
										}
										o.onkeydown = function(e){
												var chrTyped, chrCode=0, evt=e?e:event;
												chrCode = evt.which;
												var x = String.fromCharCode(chrCode);
												
												
												if(chrCode == 13){
													this.blur();
													eval("("+obj.settings.pgeOnkeydown+")");
												}else if(chrCode>=37 && chrCode<=40){
													return false;
												}else{
													return true;
												}
												
												
												
										}
									}
									if(obj.osBrowser == 10){
										o.onkeypress = function(){
											return inFlag[winId].flag;
										}
									}
								}
								//实例化密码控件窗口 
								obj.instControl(winId);
							}
						}else{
								var winPath = obj.settings.pgePath+obj.pgeditFFExe;
								$(".winA").html("请点此安装控件");
								$(".winA").attr("href",winPath);
								obj.getpgeHtml();
							}
						});
						var winPath = obj.settings.pgePath+obj.pgeditFFExe;
					return '<span  id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="display:block;" ><a class="winA" href="'+winPath+'">'+this.pgeDownText+'</a></span>';
				} else {
					return '<div id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="">暂不支持此浏览器</div>';
				}				
			},
			getDownHtml: function() {
				if (this.osBrowser==1 || this.osBrowser==3) {
					return '<div id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="line-height:28px;"><a href="'+this.settings.pgePath+this.pgeditIEExe+'">'+this.pgeDownText+'</a></div>';
				} else if (this.osBrowser==2 || this.osBrowser==6 || this.osBrowser==8) {
					return '<div id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="line-height:25px;"><a href="'+this.settings.pgePath+this.pgeditFFExe+'">'+this.pgeDownText+'</a></div>';
				} else {
					return '<div id="'+this.settings.pgeId+'_down" class="'+this.settings.pgeInstallClass+'" style="">暂不支持此浏览器</div>';
				}				
			},
			load: function(callf) {				
				if (!this.isInstalled) {
					if(!!callf) callf();
					return this.getDownHtml();
				}else{
					if(this.osBrowser==1){
						if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEdit_IE32_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return this.getDownHtml();
						} 
					}else if(this.osBrowser==3){
						if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEditt_IE64_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return this.getDownHtml();
						} 		
						
					}else if(this.osBrowser==2){  
						if(this.pgeVersion!=PGEdit_FF_VERSION && PGEdit_Update==1){
							this.setDownText();
							return this.getDownHtml();	
						}
					} else if (this.osBrowser==6) {
						if(this.pgeVersion!=PGEdit_MacOs_VERSION && PGEdit_Update==1){
							this.setDownText();
							return this.getDownHtml();	
						}
					}else if (this.osBrowser==8) {
						if(this.pgeVersion!=PGEdit_MacOs_Safari_VERSION && PGEdit_Update==1){
							this.setDownText();
							return this.getDownHtml();	
						}
					}else if (this.osBrowser == 10 || this.osBrowser == 11){
						
						return this.getpgeHtml();
					}	
				
					return this.getpgeHtml();
				}
			},
			generate: function() {
				if(this.osBrowser==1){
					   if(this.isInstalled==false){
						    this.setDownText();
							return document.write(this.getDownHtml());
						}else if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEdit_IE32_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return document.write(this.getDownHtml());
						} 
				   }else if(this.osBrowser==3){	
					    if(this.isInstalled==false){
					    	this.setDownText();
							return document.write(this.getDownHtml());
						}else if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEditt_IE64_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return document.write(this.getDownHtml());
						} 			    
			       }else if(this.osBrowser==2){
					   if(this.isInstalled==false){
						   return document.write(this.getDownHtml());	 
					   }else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_FF_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return document.write(this.getDownHtml());	
						}
					} else if (this.osBrowser==6) {
						if(this.isInstalled==false){
							return document.write(this.getDownHtml());	
						}else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_MacOs_VERSION)&& PGEdit_Update==1){
							this.setDownText();
							return document.write(this.getDownHtml());	
						}
					}else if (this.osBrowser==8) {
						if(this.isInstalled==false){
							return document.write(this.getDownHtml());	
						}else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_MacOs_Safari_VERSION) && PGEdit_Update==1){
							this.setDownText();
							return document.write(this.getDownHtml());
						}
					}
					return document.write(this.getpgeHtml());				
			},
			generate1: function() {
			    if(this.osBrowser==1){
				if(this.isInstalled==false){
				    this.setDownText();
				    return this.getDownHtml();
				}else if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEdit_IE32_VERSION) && PGEdit_Update==1){
				    this.setDownText();
				    return this.getDownHtml();
				} 
			    }else if(this.osBrowser==3){	
				if(this.isInstalled==false){
				    this.setDownText();
				    return this.getDownHtml();
				}else if(this.getConvertVersionie(this.pgeVersion)<this.getConvertVersion(PGEditt_IE64_VERSION) && PGEdit_Update==1){
				    this.setDownText();
				    return this.getDownHtml();
				} 			    
			    }else if(this.osBrowser==2){
				if(this.isInstalled==false){
				    return this.getDownHtml();	 
				}else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_FF_VERSION) && PGEdit_Update==1){
				    this.setDownText();
				    return this.getDownHtml();	
				}
			    } else if (this.osBrowser==6) {
				if(this.isInstalled==false){
				    return this.getDownHtml();	
				}else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_MacOs_VERSION)&& PGEdit_Update==1){
				    this.setDownText();
				    return this.getDownHtml();	
				}
			    }else if (this.osBrowser==8) {
				if(this.isInstalled==false){
				    return this.getDownHtml();	
				}else if(this.getConvertVersion(this.pgeVersion)<this.getConvertVersion(PGEdit_MacOs_Safari_VERSION) && PGEdit_Update==1){
				    this.setDownText();
				    return this.getDownHtml();
				}
			    }
			    return this.getpgeHtml();				
			},
			/** ***********功能性接口**************** */
			/** 清空密码* */
			pwdclear: function() {
				if (this.isInstalled) {
	               if(this.osBrowser == 10 || this.osBrowser == 11){
						var id = this.settings.pgeWindowID;
						var inputID = this.settings.pgeId;
						$("#"+inputID).val("");
						CLPJSON.id = id;
						var datac = getEnStr(this.settings.pgeRZRandNum,CLPJSON);
						var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
						jQuery.ajax( {
							url : urls,
							dataType : "jsonp",
							data : {
								"str" : JSON.stringify(RZCIJSON)
							},
							contentType : "application/json;utf-8",
							jsonp : "jsoncallback",
							success : function(x) {
								//alert("清空成功");
							}
						});
					}else{
						var control = document.getElementById(this.settings.pgeId);
						control.ClearSeCtrl();
					}
				}				
			},
			
			pwdResultRsa: function(callf) {

				var code = '';

				if (!this.isInstalled) {
					code = '';
				}
				else{	
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							control.input9=this.settings.pgeCert;
							code = control.output36;							
						} else if (this.osBrowser==2) {
							control.input(6,this.settings.pgeCert);//PEM Cer
							code = control.output(7, 4);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							control.input10=this.settings.pgeCert;
							code = control.get_output13();							
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
						
							OUTJSON.id = this.settings.pgeWindowID;
							OUTJSON.data.datatype = 7;
							OUTJSON.data.encrypttype = 4;
							var id = OUTJSON.id;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax({
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].aes = x.data;
									
									if(!!callf) callf(x);
									
								}
							});
						}						
					} catch (err) {
						code = '';
					}
				}
				return code;
			},	
			/** ***********设置性接口**************** */
			/** 设置随机数 * */
			pwdSetSk: function(s,callf) {
				
				if (this.isInstalled) {
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3 || this.osBrowser==6 || this.osBrowser==8) {
							control.input1=s;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							control.input(1,s);
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							
							var id = this.settings.pgeWindowID;
							var INCJSON = {"interfacetype":1,"data":{}};
							INCJSON.id = id;
							INCJSON.data.reg1 = this.settings.pgeEreg1;
							INCJSON.data.aeskey = s;
							var datac = getEnStr(this.settings.pgeRZRandNum,INCJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									
									if(!!callf) callf(x);
								}
							});
						}							
					} catch (err) {
						console.log(err);
					}
				}				
			},
			pwdResultHash: function() {
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}
				
				else{	
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(7);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							//code = control.get_output1();
						}					
			
			} catch (err) {
						code = '';
					}
				}
				return code;
			},
			/** ***********获取性接口**************** */
			/** 获得AES密文 * */
			pwdResult: function(callf) {
				
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}else{	
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output1;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(7);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output1();
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
						
							OUTJSON.id = this.settings.pgeWindowID;
							OUTJSON.data.datatype = 7;
							OUTJSON.data.encrypttype = 0;
							var id = OUTJSON.id;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax({
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].aes = x.data;
									
									if(!!callf) callf(x);
									
								}
							});
						}							
					} catch (err) {
						code = '';
					}
				}
				return code;
			},
			
			pwdSimple: function() {
				var code = '';
				if (!this.isInstalled) {

					code = '';
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output44;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(13);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output10();
						}
					} catch (err) {
						code = '';
					}
				}
				return code;
			},			
			pwdValid: function(callf) {
				
				var code = '';
				if (!this.isInstalled) {
					code = 1;
				}else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							if(control.output1) code = control.output5;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(5);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output5();
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 5;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].valid = x.data;
									
									if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						code = 1;
					}
				}
				return code;
			},				
			pwdHash: function(callf) {
				var code = '';
				if (!this.isInstalled) {
					code = 0;
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output2;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(2);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output2();
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 2;
							OUTJSON.data.encrypttype =1;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].hash = x.data;
									
									if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						code = 0;
					}
				}
				return code;
			},			
			pwdLength: function(callf) {
			
				var code = '';
				if (!this.isInstalled) {
					code = 0;
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output3;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(3);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output3();
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
								
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 3;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].length = x.data;
										if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						//alert(err);
						code = 0;
					}
				}
				return code;
			},
			/** 获得密码字符类型个数 * */
			pwdNum: function(callf) {
				var code = '';
				if (!this.isInstalled) {
					code = 0;
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output4;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(4);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output4();
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id; 
							OUTJSON.data.datatype = 4;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].charNum = x.data;
									//alert(outs[id].charNum);
									if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						code = 0;
					}
				}
				return code;
			},
			/** 获得密码控件版本号 * */
			getVersion: function(callf) {
				try {
					if (this.osBrowser==1) {
						var comActiveX = new ActiveXObject("LLSecurityPayEdit.PassGuardCtrl.1"); 
						return comActiveX.output35;
					}else if(this.osBrowser == 3){
						var comActiveX = new ActiveXObject("LLSecurityPayEditX64.PassGuardCtrl.1"); 
						return comActiveX.output35;
					}else if(this.osBrowser == 2 || this.osBrowser == 6 || this.osBrowser == 8 ){
						var arr=new Array();
					    if(this.osBrowser==6){
					    	var pge_info=navigator.plugins['LL Security Edit 1G'].description;
					    }else if(this.osBrowser==8){
					    	var pge_info=navigator.plugins['LL Security Edit 1G'].description;					    	
					    }else{
					    	var pge_info=navigator.plugins['LLSecurityPayEdit'].description;
					    }
						if(pge_info.indexOf(":")>0){
							arr=pge_info.split(":");
							var pge_version = arr[1];
						}else{
							var pge_version = "";
						}
					} else if (this.osBrowser == 10 || this.osBrowser == 11){
						var id = this.settings.pgeWindowID;
						OUTJSON.id = id;
						OUTJSON.data.datatype = 12;
						OUTJSON.data.encrypttype = 0;
						var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
						var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
						jQuery.ajax( {
							url : urls,
							dataType : "jsonp",
							data : {
								"str" : JSON.stringify(RZCIJSON)
							},
							contentType : "application/json;utf-8",
							jsonp : "jsoncallback",
							success : function(x) {
								if(id != undefined){
									outs[id].version = x.data;
									//alert(outs[id].version);
									if(!!callf) callf(x);
								}
							}
						});
					}
					return pge_version;
				}catch(err){
					return "";
				}					
			},
			/** 获得硬件信息列表密文 * */
			pwdHardList: function(callf){
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}else{	
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.output58;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(15);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output20();
						} else if (this.osBrowser == 10 || this.osBrowser == 11){
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 15;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].hardList = x.data;
									//alert(outs[id].hardList);
									if(!!callf) callf(x);
								}
							});
						}				
					} catch (err) {
						code = '';
					}
				}
				return code;
			},
			/** 获得MAC信息密文 * */
			machineNetwork: function(callf) {
			
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.GetIPMacList();
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(9);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output7(0);
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 9;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].mac = x.data;
									if(!!callf) callf(x);
									
								}
							});
						}
					} catch (err) {
						code = '';
					}
				}
				return code;
			},
			/** 获得硬盘信息密文 * */
			machineDisk: function(callf) {
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.GetNicPhAddr(1);
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(11);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output7(2);
						}else if (this.osBrowser == 10 || this.osBrowser == 11){
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 11;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].hard = x.data;
									if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						code = '';
					}
				}
				return code;
			},
			/** 获得CPU信息密文 * */
			machineCPU: function(callf) {
				var code = '';
				if (!this.isInstalled) {
					code = '';
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if (this.osBrowser==1 || this.osBrowser==3) {
							code = control.GetNicPhAddr(2);
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							code = control.output(10);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							code = control.get_output7(1);
						} else if (this.osBrowser == 10 || this.osBrowser == 11){
							var id = this.settings.pgeWindowID;
							OUTJSON.id = id;
							OUTJSON.data.datatype = 10;
							OUTJSON.data.encrypttype = 0;
							var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
							var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
							jQuery.ajax( {
								url : urls,
								dataType : "jsonp",
								data : {
									"str" : JSON.stringify(RZCIJSON)
								},
								contentType : "application/json;utf-8",
								jsonp : "jsoncallback",
								success : function(x) {
									outs[id].cpu = x.data;
									if(!!callf) callf(x);
								}
							});
						}
					} catch (err) {
						code = '';
					}
				}
				return code;
			},
			
			pwdStrength: function(callf) {
				var code = 0;
				if (!this.isInstalled) {
					code = 0;
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if(this.osBrowser == 10 || this.osBrowser == 11){
							
								
								var id = this.settings.pgeWindowID;
								OUTJSON.id = id;
								OUTJSON.data.datatype = 3;
								OUTJSON.data.encrypttype = 0;
								var datac = getEnStr(this.settings.pgeRZRandNum,OUTJSON);
								var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
								var obj = this;
								
								jQuery.ajax( {
									url : urls,
									dataType : "jsonp",
									data : {
										"str" : JSON.stringify(RZCIJSON)
									},
									contentType : "application/json;utf-8",
									jsonp : "jsoncallback",
									success : function(x) {
										
										var l = x.data;
										
										OUTJSON.id = id;
										OUTJSON.data.datatype = 4;
										OUTJSON.data.encrypttype =2;
										var datac = getEnStr(obj.settings.pgeRZRandNum,OUTJSON);
										var RZCIJSON = {"rankey":obj.settings.pgeRZRandNum,"datab":obj.settings.pgeRZDataB,"datac":datac};
										jQuery.ajax( {
											url : urls,
											dataType : "jsonp",
											data : {
												"str" : JSON.stringify(RZCIJSON)
											},
											contentType : "application/json;utf-8",
											jsonp : "jsoncallback",
											success : function(x) {
												
												var n = x.data;
												
												var code = 0;
												if(l==0){
													code = 0;
												}else if(n==1 || l<6){
													code = 1;//弱
												}else if(n==2 && l>=6){
													code = 2;//中
												}else if(n==3 && l>=6){
													code = 3;//强
												}
												
												if(!!callf) callf(code);
												}
										});
									}
								});
							}else{
						if (this.osBrowser==1 || this.osBrowser==3) {
							var l=control.output3;
							var n=control.output4;
							var z=control.output54;
						} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5) {
							var l=control.output(3);
							var n=control.output(4);
							var z=control.output(4,1);
						}else if (this.osBrowser==6 || this.osBrowser==8) {
							var l=control.get_output3();
							var n=control.get_output4();
							var z=control.get_output16();
						}
						if(l==0){
							code = 0;
						}else if(n==1 || l<6){
							code = 1;//弱
						}else if(n==2 && l>=6){
							code = 2;//中
						}else if(n==3 && l>=6){
							code = 3;//强
						} 
						if(!!callf) callf(code);
						   }
					} catch (err) {
						code ="";
					}
				}		
				return code;
			},	
			getConvertVersionie:function(version) {
				try {
					if(version==undefined || version==""){
						return 0;
					}else{
						var m=version.split(",");
						var v=parseInt(m[0]*1000)+parseInt(m[1]*100)+parseInt(m[2]*10)+parseInt(m[3]);
						return v;
					}
					return v;
				}catch(e){
					return 0;
				}			
			},
			getConvertVersion:function(version) {
				try {
					if(version==undefined || version==""){
						return 0;
					}else{
						var m=version.split(".");
						var v=parseInt(m[0]*1000)+parseInt(m[1]*100)+parseInt(m[2]*10)+parseInt(m[3]);
						return v;
					}
					return v;
				}catch(e){
					return 0;
				}			
			},
			setColor: function() {
				var code = '';
				if (!this.checkInstall()) {
					code = '';
				}
				else{
					try {
						var control = document.getElementById(this.settings.pgeId);
						if(this.settings.pgeBackColor!=undefined && this.settings.pgeBackColor!="") control.BackColor=this.settings.pgeBackColor;
						if(this.settings.pgeForeColor!=undefined && this.settings.pgeForeColor!="") control.ForeColor=this.settings.pgeForeColor;
					} catch (err) {
						code = '';
					}
				}
			},
			/** ***********检测性接口**************** */
			/** 检查控件是否已安装 * */
			checkInstall: function(s,callf) {
				try {
					if (this.osBrowser==1) {
						var comActiveX = new ActiveXObject("LLSecurityPayEdit.PassGuardCtrl.1"); 
					} else if (this.osBrowser==2 || this.osBrowser==4 || this.osBrowser==5 || this.osBrowser==6 || this.osBrowser==8) {
					    var arr=new Array();
					    if(this.osBrowser==6){
					    	var pge_info=navigator.plugins['LL Security Edit 1G'].description;
					    }else if(this.osBrowser==8){
					    	
					    	var pge_info=navigator.plugins['LL Security Edit 1G'].description;
					    }else{
					    	var pge_info=navigator.plugins['LLSecurityPayEdit'].description;
					    }
						if(pge_info.indexOf(":")>0){
							arr=pge_info.split(":");
							var pge_version = arr[1];
						}else{
							var pge_version = "";
						}
						
					} else if (this.osBrowser==3) {
						var comActiveX = new ActiveXObject("LLSecurityPayEditX64.PassGuardCtrl.1");
	              }else if ((this.osBrowser == 10 || this.osBrowser == 11)&&s==1){
	            	  var obj=this;
	            	  var isInatall=true;
						//指定检查是否安装的id值
	            	  var id=this.settings.pgeWindowID;
						CIJSON.id = this.settings.pgeWindowID;
						//初始化https地址
						//urls = this.settings.pgeUrls+":"+this.settings.pgePort+"/";
						
						var obj=this;
						var datac = getEnStr(this.settings.pgeRZRandNum,CIJSON);
						var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
						var chaj = jQuery.ajax( {
							timeout : 10000,
							url : urls,
							dataType : "jsonp",
							data : {
								"str" : JSON.stringify(RZCIJSON)
							},
							contentType : "application/json;utf-8",
							jsonp : "jsoncallback",
							success : function(x) {
								
								isInatall=true;
								outs[id].version=x.data;
								if(!!callf) callf(true);
								
							},
							error : function(jqXHR, textStatus, errorThrown) {
								
								if(port<5275){
									port++;
									urls=obj.settings.pgeUrls+":"+port;
									console.log(urls);	
								}else{
									console.log("没有可用端口号！！");
									console.log(urls);
									return;
									}
								isInatall=false;
								if(!!callf) callf(false);
							
							}
						});
						return isInatall;
					}
				}catch(e){
					return false;
				}
				return true;
			},
			
			setDownText:function(){
				if(this.pgeVersion!=undefined && this.pgeVersion!=""){
						this.pgeDownText="请点此升级控件";
				}
			},		
			setLicense:function(){
				if(this.isInstalled){
					var control = document.getElementById(this.settings.pgeId);
					var wlicense = "T2dDSVdvdElwWUdQQlQvN1Z2SDJJbUNjY00wNkdwK0RubXZ1bWVCQzJtY2phRHU4c1VMeVNBL2JtTk55VXN1N3hkTE50MUx1L3Zod3plWGFkWTNiMDZvbExtU0xMbUVVTUgwanNwMkNMZEkzekdCK3ZkVnhWZGRjaC9HMHVPQk1HUWF0cExkZW5YMndxRDZCZ0p1c20wcHgxS1Q0MkJQNnRWbk84Vzdudm5JPXsiaWQiOjAsInR5cGUiOiJ0ZXN0IiwicGxhdGZvcm0iOjQsIm5vdGJlZm9yZSI6IjIwMTUwODIxIiwibm90YWZ0ZXIiOiIyMDE1MTEyMSJ9";
					if(this.osBrowser == 2){
						control.LicenseEX = wlicense;
					}else if(this.osBrowser == 1 || this.osBrowser == 3){
						control.license = wlicense;
					}else if(this.osBrowser == 6 || this.osBrowser == 8 ){
						control.setlic = "clhTNzFCL25xc3ZZaTE2S3NPVzNrbnJyTWExK3ZxeGhrMUsrdjdISVpjY0Y5UGFqS0RPMk14SzFGMURhbldmUk1GWDNxVGFQb3dhcjFmeU9IL3IzWFpQaWU4NFFTZ2krcUZCQmJWVjhSTjdOWkMwUy81SWhyWFNvOVJFQXliVWJMU1h5Z0hqeXFnOERYZytsZmd0SzliMkU3azVQWUo4UzBSTVZ3aE5PRWNjPXsiaWQiOjAsInR5cGUiOiJ0ZXN0IiwicGxhdGZvcm0iOjgsIm5vdGJlZm9yZSI6IjIwMTUwODIxIiwibm90YWZ0ZXIiOiIyMDE1MTEyMSJ9";
					}
				}
			},
			pgInitialize:function(){
				if(this.isInstalled){
					if(this.osBrowser==1 || this.osBrowser==3){ 
			            jQuery('#'+this.settings.pgeId).show(); 
					}
					
					var control = document.getElementById(this.settings.pgeId);
					
					if(this.settings.pgeBackColor!=undefined && this.settings.pgeBackColor!="") control.BackColor=this.settings.pgeBackColor;
					if(this.settings.pgeForeColor!=undefined && this.settings.pgeForeColor!="") control.ForeColor=this.settings.pgeForeColor;
					
				}else{
					jQuery('#'+this.settings.pgeId+'_pge').hide();	
					if(this.osBrowser==1 || this.osBrowser==3){
						jQuery('#'+this.settings.pgeId+'_down').show();
					}	
				}
			},
			/** ***********https方案相关接口**************** */
			/** 当按enter键时，提交 * */
			setSX : function(e,m,o){
				
				var keynum;
				// IE
				if(window.event){
					keynum = e.keyCode
				// Netscape/Firefox/Opera
				}else if(e.which) {
					keynum = e.which
				}
				 var va = document.getElementById(o.id);
				 var len = va.value.length;
				 var  maxlen=this.settings.pgeMaxlength+1;
				if(len<maxlen){
				//GetLevel();
				}
				if(keynum == 13){
					
					o.blur();
					
					eval("("+m+")");
				}
			},
			/** 控制不能从中间编辑 * */
			setCX : function(ctrl) {
				var caretPos = 0; 
				// IE Support
				if (document.selection) {
					var sel = document.selection.createRange();
					sel.moveStart('character', -ctrl.value.length);
					caretPos = sel.text.length;
				// Firefox support
				}else if (ctrl.selectionStart || ctrl.selectionStart == '0'){
					caretPos = ctrl.selectionStart;
				}
				var len = ctrl.value.length;
				if (caretPos <= len) {
					// 设置光标位置函数
					if (ctrl.setSelectionRange) {
						setTimeout(function(){
							ctrl.setSelectionRange(len, len);
						},1);
					} else if (ctrl.createTextRange) {
						var range = ctrl.createTextRange();
						range.collapse(true);
						range.moveEnd('character', len);
						range.moveStart('character', len);
						range.select();
					}
				}
			},
			/** 实例化密码控件窗口 * */
			instControl : function(id) {
				var inputID=this.settings.pgeId;
				var cla=this.settings.pgeInstallClass;
				
				ICJSON.id = id;
				//获得当前指向对象
				var obj = this;
				
				var datac = getEnStr(this.settings.pgeRZRandNum,ICJSON);
				var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
				jQuery.ajax( {
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : JSON.stringify(RZCIJSON)
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
						console.log("id:"+id);
						console.log("x.data:"+x.data+",x.code:"+x.code);
						if (x.code == 0) {
							console.info("实例化成功");
						} else if(x.code==6){
							 
							this.pgeDownText = "验签失败!";
							$("#"+inputID).parent().html('<span id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="javascript:void(0);">'+this.pgeDownText+'</a></span>' );
							
							return; 
							
						}else if(x.code==7){
							var winPath = obj.settings.pgePath+obj.pgeditFFExe;
							this.pgeDownText = "无驱动,请重新下载!";
							$("#"+inputID).parent().html('<span id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="'+winPath+'">'+this.pgeDownText+'</a></span>' );
							return;
						}else if(x.code==8){
							this.pgeDownText = "驱动加载失败!";
							$("#"+inputID).parent().html('<span id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="javascript:void(0);">'+this.pgeDownText+'</a></span>' );
							
							return;
						}else if(x.code==9){
							alert("插件不支持！！");
						}
						else{
							console.info("实例化失败");
							console.info("data:" + x.data);
						}
						//初始化密码控件窗口参数
						obj.initControl(id);
						//获得控件版本
						obj.getVersion();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
				//初始化是否能输入
				inFlag[id] = {"flag":false};
			},
			/** 初始化密码控件窗口参数 * */
			initControl : function(id) {
				INCJSON.id = id;
				INCJSON.data.edittype = this.settings.pgeEdittype;
				INCJSON.data.maxlength = this.settings.pgeMaxlength;
				INCJSON.data.reg1 = this.settings.pgeEreg1;
				INCJSON.data.reg2 = this.settings.pgeEreg2;
				INCJSON.data.rsakey=this.settings.pgeCert1;
				//INCJSON.data.rsacert = this.settings.pgeCert1;
				if(this.osBrowser == 10){
					INCJSON.data.lic = {"liccode":license,"url":"aHR0cDovLzE5Mi4xNjguMS4xMTg6ODA4Ny9EZW1vWF9BTExfQUVTL2xvZ2luLmpzcA=="};
				}else if(this.osBrowser == 11){
					INCJSON.data.lic = {"liccode":licenseMac,"url":"aHR0cDovLzE5Mi4xNjguMS4xMTg6ODA4Ny9EZW1vWF9BTExfQUVTL2xvZ2luLmpzcA=="};
				}
				//alert(JSON.stringify(INCJSON));
				var datac = getEnStr(this.settings.pgeRZRandNum,INCJSON);
				var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
				jQuery.ajax( {
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : JSON.stringify(RZCIJSON)
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
						console.log("id:"+id);
						console.log("x.data:"+x.data+",x.code:"+x.code);
						isInit[id] = true;
						if (x.code == 0) {
							console.info("设置参数成功");
						} else {
							console.info("data:" + x.data);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
				//初始化对应id心跳值
				onceInterv[id]="";
			},
			/** 开启密码控件保护 * */
			openProt : function(id,inputID) {
				//设置控制输入为false
				inFlag[id].flag = false;
				OPJSON.id = id;
				var datac = getEnStr(this.settings.pgeRZRandNum,OPJSON);
				var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
				jQuery.ajax({
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : JSON.stringify(RZCIJSON)
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
						console.log("成功开启保护");
						console.log("x.data:"+x.data+",x.code:"+x.code);
						//设置控制输入为true
						inFlag[id].flag = true;
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
				// 监听焦点切出
				if(typeof onceInterv[id] == "string"){
					for(var i = 0;i < iterArray.length;i++){
						window.clearInterval(iterArray[i]);
					}
					onceInterv[id] = window.setInterval("pgeCtrl.intervlOut(\""+id+"\",\""+inputID+"\")",800);	
					iterArray.push(onceInterv[id]);
				}
				this.ajaxOnce(id);
			},
			/** 密码控件保护心跳监测 * */
			intervlOut : function(id,inputID) {
                var a=true;//检测线程是否异常
				var cla=this.settings.pgeInstallClass;
				
				XTJSON.id = id;
				var datac = getEnStr(this.settings.pgeRZRandNum,XTJSON);
				var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
				jQuery.ajax( {
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : JSON.stringify(RZCIJSON)
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
						 a=false;
						 var va = document.getElementById(inputID);
						 var len = va.value.length;
						 console.log(id+"的长度："+len);
						 console.log("x.data(长度)："+x.data+",x.code:"+x.code);
						 var y = "";
						
							 for(var i =0;i<x.data;i++){
								 y +="*";
							 }
							 va.value=y;
						 
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("--------+++++++++++");
						if(errorThrown=='timeout'){
							this.pgeDownText = "控件进程超时!";
							$("#"+inputID).parent().html('<span  id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="javascript:void(0);">'+this.pgeDownText+'</a></span>' );
								return;
						}else{
		 					console.log(errorThrown);
						this.pgeDownText = "控件进程异常停止!";
						$("#"+inputID).parent().html('<span  id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="javascript:void(0);">'+this.pgeDownText+'</a></span>' );
						return;}
					},complete: function(XMLHttpRequest,status){
						if(status=='timeout'){// 超时,status还有success,error等值的情况
							
						this.pgeDownText = "控件进程超时!";
						$("#"+inputID).parent().html('<span  id="'+inputID+'_down" class="'+cla+'" style="display:block;" ><a id="winA" href="javascript:void(0);">'+this.pgeDownText+'</a></span>' );
							return;
						}
					}
					});
			
			},
			/** 关闭密码控件保护 * */
			closeProt : function(id,inputID) {
				CPJSON.id = id;
				var datac = getEnStr(this.settings.pgeRZRandNum,CPJSON);
				var RZCIJSON = {"rankey":this.settings.pgeRZRandNum,"datab":this.settings.pgeRZDataB,"datac":datac};
				jQuery.ajax( {
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : JSON.stringify(RZCIJSON)
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
						console.log("关闭密码控件保护成功");
						console.log("x.data:"+x.data+",x.code:"+x.code);
						inFlag[id].flag = false;
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
				if(typeof onceInterv[id] == "number"){
					 for(var i = 0;i < iterArray.length;i++){
						 window.clearInterval(iterArray[i]);
					 }
					 onceInterv[id] = "";
				}
				this.ajaxOnce(id);
			},
			/** 发一次ajax * */
			ajaxOnce : function(key){
				var str = "012345"+new Date().getTime()+key;
				jQuery.ajax( {
					url : urls,
					dataType : "jsonp",
					data : {
						"str" : str
					},
					contentType : "application/json;utf-8",
					jsonp : "jsoncallback",
					success : function(x) {
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
			}
		}
	});	
})(jQuery);
var pgeCtrl = new $.pge();

/**
 * js端AES256加密
 * @param sKey 随机数
 * @param jsonStr 待加密json串
 * @return 加密好的密文
 */
function getEnStr(sKey,jsonStr) {
	var neiKey = [ 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x1A, 0x2A, 0x2B,
			0x2C, 0x2D, 0x2E, 0x2F, 0x3A, 0x3B, 0x11, 0x22, 0x33, 0x44, 0x55,
			0x66, 0x77, 0x1A, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F, 0x3A, 0x3B ];
	var fkey = "";
	var lx = "";
	for ( var i = 0; i < sKey.length; i++) {
		lx = String.fromCharCode(sKey[i].charCodeAt(0) ^ neiKey[i]);
		fkey += lx;
	}
	var hexKey = CryptoJS.enc.Utf8.parse(fkey);
	var enStr = CryptoJS.AES.encrypt(JSON.stringify(jsonStr), hexKey, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return enStr.toString();
}