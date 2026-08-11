package com.bank.processor;


import com.model.Credit;
import com.model.Debit;
import com.model.Transaction;
import com.model.Transfer;

public class TransactionProcessor {

    public void process(Transaction transaction) {

        switch (transaction) {

            case Credit credit ->
                    System.out.println(
                            "Credit processed: ₹" + credit.amount());

            case Debit debit ->
                    System.out.println(
                            "Debit processed: ₹" + debit.amount());

            case Transfer transfer ->
                    System.out.println(
                            "Transfer processed: ₹" +
                                    transfer.amount() +
                                    " to " +
                                    transfer.receiverAccount());
        }
    }
}
