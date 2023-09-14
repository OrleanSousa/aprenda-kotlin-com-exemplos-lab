enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150, Nivel.DIFICIL)

    val formacao1 = Formacao("Desenvolvedor Web", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Desenvolvedor Mobile", listOf(conteudo1, conteudo3))
    val formacao3 = Formacao("Engenheiro de Software", listOf(conteudo2, conteudo3))

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    println("Inscritos na formação ${formacao1.nome}: ${formacao1.inscritos.map { it.nome }}")

    formacao2.matricular(usuario1)

    println("Inscritos na formação ${formacao2.nome}: ${formacao2.inscritos.map { it.nome }}")

    formacao3.matricular(usuario2)

    println("Inscritos na formação ${formacao3.nome}: ${formacao3.inscritos.map { it.nome }}")
}
