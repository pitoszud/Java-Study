package DesignPatterns.ObserverA.Adapter.AdapterPlug

class Voltage{
    private var volts: Int? = null

    constructor(volts: Int){
        this.volts = volts
    }

    fun getVolts(): Int {
        return this.volts!!
    }

    fun setVolts(volts: Int){
        this.volts = volts
    }
}