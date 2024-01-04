/**
 * get api request
 */

const API_URL1 = 'https://api.github.com/users/alokkpsingh123'
const API_URL2 = 'https://dummyjson.com/quotes'
const API_URL3 = 'https://dummyjson.com/comments'


// const api1_fetch_response = fetch(API_URL1)
// .then(res => res.json())
// .then(data => console.log(data))
// .catch(error => {console.log()})

// const api2_fetch_response = fetch(API_URL2)
// .then(res => res.json())
// .then(data => console.log(data))
// .catch(error => {console.log()})

// const api3_fetch_response = fetch(API_URL3)
// .then(res => res.json())
// .then(data => console.log(data))
// .catch(error => {console.log()})

// const fetchdata = async (url) => {
//     try{
//         const response = await fetch(url)
//         if(!response.ok){
//             throw new Error("Error in the url response")
//         }
//         const data = await response.json()
//         console.log(data)
//     }catch(error){
//         console.log(error)
//     }
// }



// async function logComments() {
//     const response = await fetch("https://dummyjson.com/comments");
//     const comments = await response.json();
//     console.log(comments);
//   }

// logComments()

// fetchdata("https://dummyjson.com/comments")

/**
 * post api resquest
 */

/**
 * cookies
 */

// console.log(document.cookie)
// document.cookie = "name: alok;";
// document.cookie = "age:23;"

// localStorage.setItem("friendname", "aditya")
// localStorage.removeItem("friendname")

// const pos = navigator.connection.effectiveType
// console.log(pos)

/**
 * promise
 */

// const Promise = new Promise((res,rej)=>{
//     console.log(res, rej)
// })

// const p1 = new Promise((res, rej) => {
//     setTimeout(() => {
//       res('Promise p1 Resolved')
//     }, 20000)
//   })

//   const p2 = new Promise((res, rej) => {
//     setTimeout(() => {
//       res('Promise p2 Resolved')
//     }, 15000)
//   })

//   async function handlePromise () {
//     console.log('Hello World')

//     const d1 = await p1

//     console.log('P1 Promise')
//     console.log(d1)

//     const d2 = await p2

//     console.log('P2 Promise')
//     console.log(d2)
//   }

//   handlePromise()

/**
 * Creating get and post api using async function
 */


// const POST = "POST"
// const GET = "GET"

// const body_data = {
//     "name": "Alok singh",
//     "age": "24"
// }

// const request_method = {
//     method: "POST",
//     body: JSON.stringify(body_data)
// }

// async function getData(url, request_method) {
//     try{
//         const response = await fetch(url, request_method)
//         if(!response.ok){
//             throw new Error("Error in the url response")
//         }
//         const data = await response.json()
//         console.error(data)
//     }catch(error){
//         console.log(error)
//     }
// }

// getData("https://example.com/profile", request_method)

/**
 * DOM
 */

// document.getElementById('click-btn').innerHTML = "Math click kr"
// document.getElementById('click-btn').addEventListener()

// console.log(document.querySelectorAll(".a"))

// let buttons = document.querySelectorAll(".a");
// console.log(buttons[1])

const data = [ 
    {key: "A"},
    {key: "B"},
    {key: "C"},
    {key: "D"},
    {key: "E"},
    {key: "F"},
    {key: "G"},
    {key: "H"}
]

// const data = {
//     fname: "Alok",
//     lname: "sinhg",
//     age: 24,
//     location: "banglore"
// }
// console.log(Object.values(data))


function getRandomData(){
    let random = Math.floor(Math.random()*data.length);
    return data[random];
}



const click_button = document.getElementById("btn-click");
click_button.addEventListener('click',()=>{
    let letter = getRandomData()
    for(let a in letter){
        console.log(a)
    }

    let p = document.getElementById("main-data")
    console.log(letter)
    p.innerText = letter.key
    
})