const inq = require('inquirer');
const co = require('co');

const question = {
    type: 'input',
    message: 'what is your name boy?',
    name: 'name'
}

const lotofquestions = [question, {
    type: 'input',
    message: 'whaaat?',
    name: 'boop'
}]

co(function* () {
    var answers = yield inq.prompt(question);
    console.log(answers);
    answers = yield inq.prompt(lotofquestions);
    console.log(answers);
    expandsession();
})


const expandquestion = {
    type: 'expand',
    message: 'lets test some expand stuff',
    name: 'expand',
    choices: [
        {
            key: 'y',
            name: 'choose y',
            value: 'yvalue'
        },
        {
            key: 'a',
            name: 'choose a',
            value: 'avalue'
        },
        {
            key: 'm',
            name: 'choose m',
            value: 'mvalue'
        },
        {
            key: 'l',
            name: 'choose l',
            value: 'lvalue'
        }
    ]
    
}

function expandsession(){
    co(function* () {
        var answers = yield inq.prompt(expandquestion);
        console.log(answers);
        checkboxsession();
    });
}


var checkboxquestion = {
    type:'checkbox',
    message:'select options',
    name:'toppings',
    choices:[
      new inq.Separator(' = The X Meats = '),
      {
        name: 'Pepperoni'
      },
      {
        name: 'Ham'
      },
      {
        name: 'Ground Meat'
      },
      {
        name: 'Bacon'
      },
      new inq.Separator(' = The X Cheeses = '),
      {
        name: 'Mozzarella',
        checked: true
      },
      {
        name: 'Cheddar'
      },
      {
        name: 'Parmesan'
      },
      new inq.Separator(' = The X usual ='),
      {
        name: 'Mushroom'
      },
      {
        name: 'Tomato',
        checked: true
      },
      new inq.Separator(' = The X extras = '),
      {
        name: 'Pineapple'
      },
      {
        name: 'Olives',
        disabled: 'out of stock'
      },
      {
        name: 'Extra cheese'
      }
    ],
    validate: function (answer) {
      if (answer.length < 1) {
        return 'You must choose at least one topping.';
      }
      return true;
    }
}

function checkboxsession(){
    co(function*(){
        var answer = yield inq.prompt(checkboxquestion);
        console.log(answer);
    })
}



