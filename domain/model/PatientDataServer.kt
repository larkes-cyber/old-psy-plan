package lolka.example.PsyPath.domain.model

class PatientDataServer(
    val name:String?,
    val birthday:String?,
    val oms:String?,
    val dms:String?,
    val disease:String?,
    val pill:MutableList<ElemOfPill>,
    val spec:MutableList<ElemOfSpec>
)
