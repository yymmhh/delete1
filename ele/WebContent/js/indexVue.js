var app=	new Vue({
		 el:"#fuck_vue",
		data:{

			title:"123",
            sumPrice:{zhi:"0"},
            user_id:"",
            shop_info:{id:0,"name":"123","img":"images/test10.png"},
			type:[
				{'id':1,"name":"中餐","pid":0},
				{'id':2,"name":"饮料","pid":0},
				{'id':3,"name":"西餐","pid":0},
				{'id':4,"name":"小吃","pid":0},
				{'id':5,"name":"特色","pid":0},
				{'id':6,"name":"糕点","pid":0},
				{'id':7,"name":"水果","pid":0},


			],
			shop:[
			{"id":1,"name":"中餐抄鸡蛋","pid":1,"img":"images/test10.png","cartcount":"0","price":"10"},
			{"id":2,"name":"中餐牛排","pid":1,"img":"images/test10.png","cartcount":"0","price":"20"},
			{"id":3,"name":"中餐西瓜汁","pid":1,"img":"images/test10.png","cartcount":"0","price":"30"},
			{"id":4,"name":"中餐香蕉","pid":1,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":5,"name":"中餐西红柿","pid":1,"img":"images/test10.png","cartcount":"0","price":"100"},


			{"id":6,"name":"饮料牛肉","pid":2,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":7,"name":"饮料牛肉","pid":2,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":8,"name":"饮料牛肉","pid":2,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":9,"name":"饮料牛肉","pid":2,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":10,"name":"饮料牛肉","pid":2,"img":"images/test10.png","cartcount":"0","price":"100"},

			{"id":11,"name":"西餐抄鸡蛋","pid":"3","img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":12,"name":"西餐抄鸡蛋","pid":"3","img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":13,"name":"西餐抄鸡蛋","pid":"3","img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":14,"name":"西餐抄鸡蛋","pid":"3","img":"images/test10.png","cartcount":"0","price":"100"},


			{"id":15,"name":"小吃抄鸡蛋","pid":4,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":16,"name":"小吃抄鸡蛋","pid":4,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":17,"name":"小吃抄鸡蛋","pid":4,"img":"images/test10.png","cartcount":"0","price":"100"},

			{"id":18,"name":"特色抄鸡蛋","pid":5,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":19,"name":"特色抄鸡蛋","pid":5,"img":"images/test10.png","cartcount":"0","price":"100"},



			{"id":20,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":21,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":22,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":23,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":24,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":25,"name":"小吃抄鸡蛋","pid":6,"img":"images/test10.png","cartcount":"0","price":"100"},


			{"id":26,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":27,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":28,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":29,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":30,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":31,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":32,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},
			{"id":33,"name":"小吃抄鸡蛋","pid":7,"img":"images/test10.png","cartcount":"0","price":"100"},



			],

            cart:[



            ],
            tempCart:{"id":0,"count":0,"name":"","tempsum":"0"}

		},
      methods:{

		     wl_count(info){
                 var count=info.length;
//                 alert(count);
                 $("#count").html(count);
             },



//		     加
              wl_jia(itemtwo){
              
              	$(".items").show();
                //var zhi= $(this).prev("input").val();
                // if(zhi<=0){
                //     $("#showToast").click();
                //     return;
                // }
                var i=parseInt(itemtwo.cartcount)+1;
                
                itemtwo.cartcount=i;
                $("#an").click();
                $("#wl_goshop_tiao").hide();
                
              



                  if( this.cart.length<1){
                      console.log("数组的个数为"+this.cart.length);
                      let tempprice=parseInt(itemtwo.price)*parseInt(itemtwo.cartcount);
                      this.tempCart={id:itemtwo.id,"count":itemtwo.cartcount,"name":itemtwo.name,"tempsum":tempprice};
                      this.cart.push(this.tempCart);
                      this.tempCart={"id":0,"count":0,"name":""};
                      this.$options.methods.wl_count(this.cart);
                      this.$options.methods.wl_cookie(this.cart,this.shop);
                      this.$options.methods.sumfunction(this.cart,this.sumPrice);
                      return false;
                  }
                  var zhi=0;
                  this.cart.forEach(function(value, index, array) {
                      if(value.id==itemtwo.id){
                          zhi=1;
                          console.log("数组中有这个");
                          console.log("刚开始的个数"+value.count);
                          value.count=parseInt(value.count)+1;

//                          break;
//                          return false;



                      }else{


                      }

                  });
                  if(zhi==0){
//                      alert(itemtwo.price+""+itemtwo.cartcount);
                      let tempprice=parseInt(itemtwo.price)*parseInt(itemtwo.cartcount);
                      this.tempCart={id:itemtwo.id,"count":itemtwo.cartcount,"name":itemtwo.name,"tempsum":tempprice};
                      console.log("错误的前一步");
                      console.log(this.cart);
                      console.log(this.tempCart);
                      this.cart.push(this.tempCart);
                  }


//                  console.log(this.cart);
                  this.$options.methods.wl_count(this.cart);
                       console.log("最后打印结果！");
                  console.log(this.cart);



                  //                  我在此处再加一个Cookie缓存


                  //先都把cookie清空

                  this.$options.methods.wl_cookie(this.cart,this.shop);
                  this.$options.methods.sumfunction(this.cart,this.sumPrice);



              },


          //加一个方法
          //这是在购物车里面的时候加减


          cart_jia(item){
            // console.log(item);
            var cart=this.cart;
            var shop=this.shop;
              shop.forEach(function (itemtwo,index) {
                if(itemtwo.id==item.id){
                    console.log("找到了");
                    console.log(itemtwo);

                    item.count=parseInt(item.count)+1;
                    itemtwo.cartcount=item.count;


                }
                
            })
              this.$options.methods.wl_cookie(this.cart,this.shop);
              this.$options.methods.sumfunction(this.cart,this.sumPrice);
          },

          //这边是弹出购物车的那个加减
          cart_jian(item){
        	  console.log("购物车建议下!");
        	  console.log(item);
        	  if(item.count<=0){
        		  return;
        		  
        	  }
              var cart=this.cart;
              var shop=this.shop;
              shop.forEach(function (itemtwo,index) {
                  if(itemtwo.id==item.id){
                      console.log("找到了");
                      console.log(itemtwo);

                      item.count=parseInt(item.count)-1;
                      itemtwo.cartcount=item.count;



                  }

              });
              this.$options.methods.wl_cookie(this.cart,this.shop);
              this.$options.methods.sumfunction(this.cart,this.sumPrice);
          },


//Cookie从新赋值的方法
          wl_cookie(objectcart,objectshop){
		         console.log("开始Cookie")
            console.log(objectshop);
		         // console.log(itemtwo);
              $.cookie("wl_cart",null);


              let wl_cart="";
              objectcart.forEach(function (item,index) {

                  objectshop.forEach(function (itemtwo,twoindex) {
                      if(item.id==itemtwo.id){
                          item.tempsum=parseInt(itemtwo.cartcount)*parseInt(itemtwo.price);

                      }

                  })




                  // let tempprice=parseInt(itemtwo.price)*parseInt(itemtwo.cartcount);
                  var tempitem=item.id+"!"+item.count+"!"+item.name+"!"+item.tempsum;
                  wl_cart+=tempitem+",";
              })


              //开始赋值
              $.cookie('wl_cart',wl_cart, { expires: 7 });
//
              var zhi= $.cookie("wl_cart");
              console.log("查看Cookie的内容");
              console.log(zhi);

          },
//减少内容
          wl_jian(itemtwo){
                	 
                	 if(itemtwo.cartcount<=0){
                		 $("#showToast").click();
                         return;
                		
                	 }
                	 $("#an").click();
                     $("#wl_goshop_tiao").hide();
                	 var i=parseInt(itemtwo.cartcount)-1;
                     
                     itemtwo.cartcount=i;
//                    alert(1);
              console.log(itemtwo.id);
              var isdelete=0;
              var isindex=0;
              this.cart.forEach(function(value, index, array) {
                  if(value.id==itemtwo.id){
                      console.log("数组中有这个");
                      console.log("刚开始的个数"+value.count);
                      value.count=value.count-1;
                        if(value.count==0){
                            isdelete=1;
                            isindex=index;
                            console.log("这个字段的索引是"+index);
                        }


                  }else{

                  }

              });

              if(isdelete==1){
                  this.cart.splice(isindex,1);

              }

              this.$options.methods.wl_count(this.cart);
              console.log("最后打印结果！");
              console.log(this.cart);

              this.$options.methods.wl_cookie(this.cart,this.shop);
              this.$options.methods.sumfunction(this.cart,this.sumPrice);
//              console.log("开始循环");

          },

          wl_shop_info(item){
		         // alert(1);
		         console.log(item);
		         this.shop_info={"id":item.id,"name":item.name,"img":item.img};
		         $("#u").click();

          },

          //计算总价格
          sumfunction(item,price){
		         console.log("开始计算价格！");


              // console.log(price.zhi);

              var lin=0;
              item.forEach(function (tempitem,index) {
		             console.log(tempitem.tempsum);
                  lin=lin+parseInt(tempitem.tempsum);

                 })

              price.zhi=lin;


              console.log("最后价格为+");
              console.log(price);





          },


          //购物车里面删除商品
          wl_deletShop(item){
		         // alert("kaishi");
                console.log("静茹删除方法");
                console.log(this.cart);

                var listcart=new Array();
                var index;
                this.cart.forEach(function (itemtwo,tempindex) {
                    // console.log(item);
                    if(itemtwo.id==item.id){
                      index=tempindex;
                    // console.log(itemtwo);

                    }else{
                        listcart.push(itemtwo);
                    }

                    
                })
              
              
              this.shop.forEach(function (itemshop,shopindex) {

                  // console.log("进入循环！");

                  if(item.id==itemshop.id){

                      console.log("找到了！")
                      console.log(itemshop);
                      itemshop.cartcount=0;
                  }
              })
              console.log(listcart);
              this.cart.splice(index,1);
                this.cart=listcart;
              // this.cart.splice(item.id,1);
              this.$options.methods.wl_count(this.cart);
              // console.log(this.cart);
              this.$options.methods.wl_cookie(this.cart,this.shop);
              this.$options.methods.sumfunction(this.cart,this.sumPrice);
          },

          //最后开始结算
          wl_buygo(){


              var temp=new Array();
              var tempnew=new Array();
              console.log(this.cart);
              var info=this.cart;
              var shopInfoString="";
              info.forEach(function (item,index) {
//                var tempcart={id:item.id,count:item.count};
            	  var tempcart=item.id+":"+item.count+"!";

            	  shopInfoString+=tempcart;
              })
              console.log(shopInfoString);
            
              

//              console.log(temp);
              
              var total=this.sumPrice.zhi;
              console.log("总价"+total);
              $.ajax({
                  type: 'POST',
                  url: "FoodServlet?opr=add",
                  data: "json="+shopInfoString+"&total="+total+"&user_id=",

                  dataType: "json",
                  success: function(eve){
                	  console.log(eve.status);
                      if(eve.status==1){
                          //就是订单提交成功了
                          location.href="message.html?message=4";
                      }

                  }
              });
          },

          wlload(){
          	axios.post('FoodServlet?opr=allFood', {
    
    
		  })
		  .then(function (response) {
		    console.log(response.data.shop);
		    console.log(this.shop);
		    
		  })
		  .catch(function (error) {
		    console.log(error);
		  });
          }



      },
      computed:{
    todoCount:function(){
      return this.cart.length;
    }
  },
  
  //这是AJax请求的,
   mounted() {
       console.log("App开始加载Ajax");
       axios.post("LoginServlet?type=getSession").then(response=>{
    	   var user_id=response.data.user_id;
   		if(user_id==null || user_id==0 ||user_id<1){
   			location.href="error.html?message=1";
   			return;
   			
   		}else{
   		    this.user_id=user_id;
   		 console.log(this.user_id);
   		}
       }).catch(function(){
    	   location.href="error.html?message=1";

       })
       
   
       
       
       // 这边是申淋些代码
       
     
       
       
     axios.get('FoodServlet?opr=allFood').then((response) => {
         console.log(response.data);
       //this.todos=response.data;
       //console.log(this.shop);
    
       var arr=new Array();
       
       var tempdui={"id":0,"name":"0","pid":0,"img":"images/test10.png","cartcount":"0","price":"0"};
       var temp= response.data.shop;
       temp.forEach(function(item,index){
       	//console.log(item);
       		tempdui.id=item.id;
       		tempdui.name=item.name;
       		tempdui.pid=item.typeId;
       		tempdui.img=item.picSrc;
       		tempdui.price=item.price;
       		
    
       		arr.push(tempdui);
    
       	tempdui={"id":0,"name":"0","pid":0,"img":"images/test10.png","cartcount":"0","price":"0"};
       })
       console.log("FUCK一下");
       console.log(arr);
       this.shop=arr;
       
       console.log(this.shop);
    
       //开始循环那个类型
       var tempkontype=new Array();
       var temptype= response.data.type;
       var temptypeinfo={'id':1,"name":"中餐","pid":0};
       temptype.forEach(function(item,index){
       	//console.log(item);
       		temptypeinfo.id=item.id;
       		temptypeinfo.name=item.typeName;
       		tempkontype.push(temptypeinfo);
    
       		temptypeinfo={'id':1,"name":"中餐","pid":0};
    
    
    
       })
    
    
       this.type=tempkontype;
       //console.log(this.type);
       //this.shop=arr;
       //this.shop=;
    
       //this.type=response.data.type;
       
       
       
       
       console.log("我特么看看Ajax加载完什么样子");
//     
     console.log(this.shop);
     console.log(this.type);
     
     
     
     
       console.log("APP开始加载Cookie!");
       var arr=new Array();
       var zhi= $.cookie("wl_cart");
       // alert(zhi);
       var cartjson=new Array();
       var tempshop=this.shop;
       console.log("查看Cookie的内容");
       arr= zhi.split(",");
//          console.log(arr);
       //出除数组中的空元素
       arr.forEach(function (item,index) {
           console.log(item);
           if(item==""){
               // arr.splice(index, 1);


           }else{

               var temp= item.split("!");
//
               console.log(temp);

               //现在就开始循环商品里面的cartcount
               tempshop.forEach(function (tempitem,index) {
                   //
                   if(temp[0]==tempitem.id){
                       tempitem.cartcount=temp[1];

                   }
               });

               // let tempprice=parseInt(itemtwo.price)*parseInt(itemtwo.cartcount);
               // this.tempCart={id:itemtwo.id,"count":itemtwo.cartcount,"name":itemtwo.name,"tempsum":tempprice};
               var tempjson={"id":temp[0],"count":temp[1],"name":temp[2],"tempsum":temp[3]};
//                  console.log(tempjson);
               cartjson.push(tempjson);

           }
//                console.log(item);

       })

       console.log(tempshop);

       console.log(cartjson);
       this.cart=cartjson;



       //重新加载购物车
       this.$options.methods.wl_count(this.cart);
       this.$options.methods.sumfunction(this.cart,this.sumPrice);
       
       
    
     })





       // 加载Cookie

     

   }

       //console.log(this.shop);
    
	
	
  



	})



