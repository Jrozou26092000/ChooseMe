Vue.component('signin', {
    template: //html
    `
    <div>
        <template>
        <form>
            <p class="h4 text-center mb-4">Sign in</p>
            <label for="defaultFormLoginEmailEx" class="grey-text">Your email</label>
            <input type="email" id="defaultFormLoginEmailEx" class="form-control"/>
            <br/>
            <label for="defaultFormLoginPasswordEx" class="grey-text">Your password</label>
            <input type="password" id="defaultFormLoginPasswordEx" class="form-control"/>
            <div class="text-center mt-4">
            <b-button href="#">Log In</b-button>
            </div>
        </form>
        </template>
    </div>
    `,
    data(){
        return {
            texto: 'Hola'
    }
}
});