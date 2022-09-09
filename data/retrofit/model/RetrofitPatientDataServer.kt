package lolka.example.PsyPath.data.retrofit.model


class RetrofitPatientDataServer(
    val name:String?,
    val birthday:String?,
    val oms:String?,
    val dms:String?,
    val disease:String?,
    val pill:MutableList<RetrofitElemOfPill>,
    val spec:MutableList<RetrofitElemOfSpec>
)