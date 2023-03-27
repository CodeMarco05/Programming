const canvas = document.querySelector('canvas')

const c = canvas.getContext('2d')

const background = new Image()
background.src = './img/Town.png'

const player = new Image()


//------------//




canvas.width = 1024
canvas.height = 567

console.log(background)

background.onload = () =>{
	c.drawImage(background,-200,-700)
}
