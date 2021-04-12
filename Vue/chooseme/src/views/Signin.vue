<template>
    <div class="signin">
        <b-container>
            <b-card 
                header="Bienvenidos a ChooseMe!"
                header-bg-variant="dark"
                header-text-variant="white"
                align="center"
            >   

            <b-form @submit="onLogin" v-if="show">
                <b-form-group
                    id="input-group-1"
                    label="Nombre de Usuario:"
                    label-for="input-1"
                >
                    <b-form-input
                    id="input-1"
                    v-model="form.user"
                    type="text"
                    placeholder="Ingrese su nombre de usuario"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="input-group-2"
                    label="Correo electrónico:"
                    label-for="input-2"
                >
                    <b-form-input
                    id="input-2"
                    v-model="form.email"
                    type="email"
                    placeholder="Ingrese su correo electrónico"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="input-group-3"
                    label="Nombre:"
                    label-for="input-3"
                >
                    <b-form-input
                    id="input-3"
                    v-model="form.name"
                    type="text"
                    placeholder="Ingrese su nombre"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group
                    id="input-group-4"
                    label="Apellido:"
                    label-for="input-4"
                >
                    <b-form-input
                    id="input-4"
                    v-model="form.lastname"
                    type="text"
                    placeholder="Ingrese su apellido"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group 
                    id="input-group-5" 
                    label="Teléfono:" 
                    label-for="input-5"
                >
                    <b-form-input
                    id="input-5"
                    v-model="form.phone"
                    placeholder="Ingrese su teléfono"
                    type = "tel"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group 
                    id="input-group-6" 
                    label="Contraseña:" 
                    label-for="input-6"
                >
                    <b-form-input
                    id="input-6"
                    v-model="form.password"
                    placeholder="Ingrese su contraseña"
                    type = "password"
                    required
                    ></b-form-input>
                </b-form-group>

                <b-form-group 
                    id="input-group-7" 
                    label="Verificar contraseña:" 
                    label-for="input-7"
                >
                    <b-form-input
                    id="input-7"
                    v-model="form.passwordagain"
                    placeholder="Ingrese su contraseña"
                    type = "password"
                    required
                    ></b-form-input>
                </b-form-group>
               

                <b-button type="submit" variant="secondary">Sign in</b-button>

            </b-form>

                <template #footer>
                    <small class="text-muted">¿Ya tienes cuenta? Inicia sesión
                        <b-link to="/login">aquí</b-link>.
                    </small>
                </template>
            </b-card>
            <!-- <b-card class="mt-3" header="Form Data Result">
                <pre class="m-0">{{ form }}</pre>
            </b-card> -->
        </b-container>
    </div>
</template>

<script>
  import axios from 'axios';
  export default {
    data() {
      return {
        form: {
            user: '',
            email: '',
            name: '',
            lastname: '',
            phone: '',
            password: '',
            passwordagain: ''
        },
        show: true
      }
    },
    methods: {
      onLogin(event) {
        event.preventDefault()
        // API REST
        let json = {
            "user_name" : this.form.user,
            "email" : this.form.email,
            "password" : this.form.password,
            "passtemp" : this.form.passwordagain,
            "name" : this.form.name,
            "lastname" : this.form.lastname,
            "phone" : this.form.phone
        };
        axios.post('http://localhost:8080/users/add',json).then(
          data => {
            console.log(data);
          }
        )
        // Reset our form values
        this.form.user = ''
        this.form.email = ''
        this.form.name = ''
        this.form.lastname = ''
        this.form.phone = ''
        this.form.password = ''
        this.form.passwordagain = ''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>