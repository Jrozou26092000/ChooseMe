<template>
    <div class="login">
        <b-container>
            <b-card 
                header="Bienvenidos a ChooseMe!"
                header-bg-variant="dark"
                header-text-variant="white"
                align="center"
            >   

            <b-form v-if="show">
                <b-form-group
                    id="input-group-1"
                    label="Correo electrónico:"
                    label-for="input-1"
                >
                    <b-form-input
                    id="input-1"
                    v-model="form.email"
                    type="email"
                    placeholder="Ingrese su correo electrónico"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Contraseña:" label-for="input-2">
                    <b-form-input
                    id="input-2"
                    v-model="form.password"
                    placeholder="Ingrese su contraseña"
                    type = "password"
                    required
                    ></b-form-input>
                </b-form-group>
            </b-form>

            <b-button v-on:click="onLogin" variant="secondary">Log In</b-button>
                <template #footer>
                    <small class="text-muted">¿Aún no tienes cuenta? Resgístrate aquí.</small>
                </template>
            </b-card>
            <b-card class="mt-3" header="Form Data Result">
                <pre class="m-0">{{ form }}</pre>
            </b-card>
        </b-container>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
            email: '',
            password: ''
        },
        show: true
      }
    },
    methods: {
      onLogin(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.password = ''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>