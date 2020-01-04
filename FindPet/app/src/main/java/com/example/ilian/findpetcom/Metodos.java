package com.example.ilian.findpetcom;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.PhoneNumberUtils;

public class Metodos {

    public static void clicInfo(Dialog myDialog ){






    }

    public static void abrirWhatsapp(String telefono, Dialog myDialog) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators(telefono)+"@s.whatsapp.net");
        myDialog.getContext().startActivity(_intencion);
    }
}
