// let a = true;
// var b = "Alok";
// const c = 10;

// alert(a+b+c)

// let a = 10
// let b  = "20"
// console.log(b+a)

// let num = 8
// console.log(typeof num)
// let num
// console.log(`alhaga ${num}`)

// let x = true
// console.log(typeof String(x))

// console.log('24'/'3')

// console.log( Number("  123  "))
// console.log( Number("123z"))
// console.log( Number("true"))
// console.log( Number("false"))
// console.log( Boolean(-1))
// console.log( Boolean(0))

// if(-1) console.log("kahdslhalfd")

// let n = prompt("Enter the value")
// if(n % 2 == 0) alert("even") 
// else alert("odd")


// console.log(1+ 3+ "Alok"+ 16 + 4)

// let ch = prompt("Enter the day number your want:")
// switch(ch){
//     case '0' : alert("Monday") 
//     break
//     case '1' : alert("Tuesday")
//     break
//     case '2' : alert("Wednesday")
//     break
//     case '3' : alert("Thrusday")
//     break
//     case '4' : alert("Friday")
//     break
//     case '5' : alert("Saturday")
//     break
//     case '6' : alert("Sunday")
//     default: alert("Wrong input")
// }

// const a = [1,1,2,2,3,3,4]
// var ele = a[0]
// for(let i = 1; i< a.length; i++){
//     ele = ele^a[i]
// }
// console.log(ele)

// console.log(Math.E)
// console.log(Math.PI)
// console.log(Math.sqrt(4))
// console.log(Date())
// console.log(Math.random())

// let date = new Date()

// function getWeekDay(date){
//     switch(date.getDay()){
//         case 1 : console.log("MO")
//         break
//         case 2 : console.log("TU")
//         break
//         case 3 : console.log("WE")
//         break
//         case 4 : console.log("TH")
//         break
//         case 5 : console.log("FR")
//         break
//         case 6 : console.log("SA")
//         break
//         case 0 : console.log("SU")
//         default: alert("Wrong input")
//     }
// }

// getWeekDay(date)

// getName();
// let a ;
// console.log(a)
// function getName(){
//     console.log("inside function")
// }
// var a=10;
// console.log(window)



// function getName(){
//     // var fName = "Singh"
//     function getAge(){
//         console.log(fName);
//      }
//     console.log(fage)
//     getAge();
// }
// var fName = "Alok"
// var fage = 10;
// getName()

// function a(){
//     var b = 100
//     c()
//     function c(){
//         console.log(b)
//     }
// }
// var b = 10
// a()


// var a = ()=>{
//     var b = 100
    
//      var c = ()=>{
//         console.log(b)
//     }
//     c()
// }
// var b = 10
// a()

// var a = 888
// {
//     var a = 10
//     let b = 10
//     var a = 10
// }

// console.log(b)
// console.log(a)
// let a = 10
// var b = 100


/**
 * join() -> created new arr with some seperator
 * indexOf(searchElement, startSearch) -> gives the index on searching the
 * includes() -> checks the element present or not
 * push() & pop()
 * splice() -> changes the array and returns the removed array.
 * shift() -> pop first index
 * unshift() -> insert at first index
 * concat() -> merging two or more array
 * [...anyArrayName] -> useed to copy the array
 * map, reduce, filter
 */

const fruits = ['mango', 'guava', 1, 2]
fruits[0] = 'applle'

const cars = new Array('Ford','bmw','tata','maruti');
// console.log(cars.indexOf('bmw'));

// console.log(cars.includes("affljd"))

const arr = [1,4,2,6,5,8]
// console.log(arr.sort())

// console.log(arr.splice(2))
// console.log(arr)
// console.log(arr.splice(2,0,9))

// console.log(arr.unshift())
// console.log(arr)

// arr.forEach((a,i)=>{
//     console.log("element: " +a + " index"+i)
// })

// console.log(cars.concat(fruits))
// const res = [...cars]
// console.log(res)

// const arrRes = arr.map( (i) => i*2);
// console.log(arrRes)


// const arrRes2 = arr.filter((i) => i% 2 == 0)
// console.log(arrRes2)

// const min = arr.reduce((acc,curr) => { 
//     if(curr < acc){ acc = curr}
//     return acc
// },100)

// console.log(min)

/**
 * Objects:
 * 
 * arrow function can not be hosited.
 */

// let a = {
//     "name":"Alok",
//     "age":23,
//     "email": "@lokkpsingh123",
//     "phone":"8853404979",
//     login : function(){console.log(this)},
//     signin: ()=>{console.log(this)}
// }

// a.login()
// a.signin()


/**
 * shallow copy: reference copy, Object.assign()
 * deep copy: does not copy the reference, JSON.parse(JSON.stringify(a))
 * for( let x (in,or) arr) -> in used for checkin in the arr, and of 
 */

// let b = JSON.parse(JSON.stringify(a))
// b.age = 24;

// console.log(a)


// let user = {
//     "name" : "John",
//     "surname" : "Smith"
// }

// console.log(user)
// let newUser = JSON.parse(JSON.stringify(user));
// newUser.name = "Pete"
// delete newUser.surname
// console.log(newUser)


// const a1 = {
//     color:'black'
// }

// const a2 = {
//     color:'red',
//     mobile: "Iphone"
// }

// const a3 = {
//    mobile: '2GB',
//    rom: '16GB'
// }

// console.log(Object.assign(a1,a2,a3))


/**
 * Rest properties:
 */

// const[v,x, ...others] = [1,2,3,4,5]
// console.log(v)
// console.log(x)
// console.log(others[2])

/**
 * Callback
 */

// function a(){
//     console.log("inside a")
// }

// function b(c){
//     console.log("inside b") 
//     c()   
// }

// b(a)

// const timer = setTimeout(()=>{
//     console.log("this is 1st statement")
// },5000)

// const timer1 = setTimeout(()=>{
//     console.log("this is 2st statement")
// },2000)

// const timer2 = setTimeout(()=>{
//     console.log("this is 3st statement")
// },1000)

/**
 * call back queue
 * call back hell
 * 
 */

const p1 = new Promise((res, rej) => {
    setTimeout(() => {
      res('Promise p1 Resolved')
    }, 20000)
  })
  
  const p2 = new Promise((res, rej) => {
    setTimeout(() => {
      res('Promise p2 Resolved')
    }, 15000)
  })
  
  async function handlePromise () {
    console.log('Hello World')
  
    const d1 = await p1
  
    console.log('P1 Promise')
    console.log(d1)
  
    const d2 = await p2
  
    console.log('P2 Promise')
    console.log(d2)
  }
  
  handlePromise()