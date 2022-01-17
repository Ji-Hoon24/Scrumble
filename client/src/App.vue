<template>
	<div id="app">
    <div class="inner">
        <todo-header></todo-header>
        <div class="head-class">[한일]</div>
        <todo-input v-on:addTodo="addTodo"></todo-input>
        <todo-list v-bind:propsdata="todoItems" @removeTodo="removeTodo"></todo-list>
        <todo-footer v-on:removeAll="clearAll"></todo-footer>
        <div class="head-class">[할일]</div>
        <todo-input v-on:addTodo="addTodo"></todo-input>
        <todo-list v-bind:propsdata="todoItems" @removeTodo="removeTodo"></todo-list>
        <todo-footer v-on:removeAll="clearAll"></todo-footer>
        <div class="head-class">[오늘의 생각]</div>
        <todo-input v-on:addTodo="addTodo"></todo-input>
        <todo-list v-bind:propsdata="todoItems" @removeTodo="removeTodo"></todo-list>
        <todo-footer v-on:removeAll="clearAll"></todo-footer>
        <div class="saveContainer">
          <span class="saveBtn" @click="">Save</span>
        </div>
    </div>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue';
import TodoInput from './components/TodoInput.vue';
import TodoList from './components/TodoList.vue';
import TodoFooter from './components/TodoFooter.vue';

export default {
    data() {
        return {
            todoItems: []
        }
    },
    created() {
        if(localStorage.length > 0) {
            for(var i=0; i < localStorage.length; i++) {
                this.todoItems.push(localStorage.key(i));
            }
        }
    },
    methods: {
        addTodo(todoItem) {
            localStorage.setItem(todoItem, todoItem);
            this.todoItems.push(todoItem);
        },
        clearAll() {
            localStorage.clear();
            this.todoItems = [];
        },
        removeTodo(todoItem, index) {
            localStorage.removeItem(todoItem);
            this.todoItems.splice(index, 1);
        },
    },
    components: {
        'todo-header': TodoHeader,
        'todo-input': TodoInput,
        'todo-list': TodoList,
        'todo-footer': TodoFooter,
    }
}
</script>

<style>
body {
    text-align: center;
    background-color: #F6F6F8;
}
input {
    border-style: groove;
    width: 200px;
}
button {
    border-style: groove;
}
.shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
#app {
    text-align: center;
}
.inner {
  max-width: 650px;
  width: 100%;
  display: inline-block;
}
.head-class{
  padding: 5px;
}
.saveContainer {
    width: 8.5rem;
    height: 50px;
    line-height: 50px;
    border-radius: 5px;
    margin: 0 auto;
    padding-top: 50px;
}
.saveBtn {
    background-color: lightblue;
    color: white;
    display: block;
}
</style>