let cards = []

let sum

let sumel = document.getElementById('sum-el')
let cardel = document.getElementById('card-el')
let playerEl = document.getElementById('player-id')
let msg = document.getElementById('message-el')


let isAlive = true
let hasBlackJack = false

let player = {
  name: 'Alok',
  chips: 200
}

playerEl.innerText = player.name + ": $" + player.chips

function getRandom() {
  const x = Math.floor(Math.random()*13) + 1
  if (x > 10) {
    return 10
  } else if (x==1) {
    return 11
  } else {
    return x
  }
}

function start() {
  isAlive = true
  let firstCard = getRandom()
  let secondCard = getRandom()
  cards = [firstCard, secondCard]
  sum =  firstCard + secondCard
  renderGame()
}
function renderGame() {
  cardel.textContent = 'Cards : '
  for (let i = 0; i < cards.length; i++) {
    cardel.textContent += cards[i] + " "
  }
  sumel.textContent = 'Sum : ' + sum
  if (sum < 21) {
    msg.innerText = 'You are Still Alive, Want to draw a card?'
  } else if (sum === 21) {
    msg.innerText = 'Wooh! You Won'
    hasBlackJack = true
  } else {
    msg.innerText = 'You Lose'
    isAlive = false
  }
}

function newCard () {
  if (isAlive && !hasBlackJack) {
    let newCard = getRandom()
    sum += newCard
    cards.push(newCard)
    renderGame()
  }
}